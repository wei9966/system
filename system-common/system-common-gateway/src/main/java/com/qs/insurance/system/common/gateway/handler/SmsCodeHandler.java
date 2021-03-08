package com.qs.insurance.system.common.gateway.handler;

import cn.hutool.core.util.StrUtil;
import com.qs.insurance.system.common.core.constant.CommonConstants;
import com.qs.insurance.system.common.core.constant.Constant;
import com.qs.insurance.system.common.core.utils.R;
import com.qs.insurance.system.common.core.utils.ZgxApiUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @description 短信验证码获取类
 * @create 2020-05-08 17:32
 **/
@Slf4j
@Component
@AllArgsConstructor
public class SmsCodeHandler implements HandlerFunction<ServerResponse> {
    private final RedisTemplate redisTemplate;
    @Override
    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Object.class));
        String result = "短信发送成功！";
        boolean success = true;
        String zgxToken = redisTemplate.opsForValue().get(CommonConstants.ZGX_API_TOKEN) + "";
        if (StrUtil.isBlank(zgxToken) || StrUtil.equals("null", zgxToken)){
            zgxToken = ZgxApiUtils.getApiToken();
            redisTemplate.opsForValue().set(CommonConstants.ZGX_API_TOKEN, zgxToken, CommonConstants.ZGX_API_TOKEN_TIME, TimeUnit.SECONDS);
        }
        if (StrUtil.isBlank(zgxToken) || StrUtil.equals("null", zgxToken)){
            success = false;
            result = "短信发送失败，请重试！";
        }else{
            //生成验证码
            String text = getVerificationCode();
            String phone = serverRequest.queryParam("phone").get();

            String content = "验证码：您的登录验证码为" + text + "，有效期10分钟，如非本人操作请忽略。【互联网医院平台】";
            ZgxApiUtils.sendSms(zgxToken, phone, content);
            //保存验证码信息
            redisTemplate.opsForValue().set(CommonConstants.WX_PHONE_CODE_KEY + phone, text
                    , CommonConstants.CODE_TIME, TimeUnit.SECONDS);
        }

        // 转换流信息写出
        return ServerResponse
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(new R().setCode(success ? Constant.BYTE_YES : Constant.BYTE_NO).setMsg(result)));
    }

    /**
     * @return
     */
    private String getVerificationCode(){
        char[] word = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        //声明一个四位验证码的字符数组（提示多少个验证码字符就改vc数组的长度）
        char[] vc = new char[4];
        /*
         * for循环的目标是：每循环一次，找到word字符数组中的任意一个字符，把它赋给字符数组vc.
         * 循环完vc的长度，也就实现全部给vc字符数组赋值了。
         * */
        for (int i = 0; i < vc.length; i++) {
            //产生一个随机数，范围在0---61之间，因为word数组共有62个字符,数组索引从0开始，0--61共62个数。
            int number = (int) (Math.random() * (word.length));
            /*随机获取word字符数组中的任意一个字符。依次将它赋给字符数组vc，
              该for循环运行4次，vc数组也抽取到了word中的任意4个字符。
            * */
            vc[i] = word[number];
        }
        //创建一个字符串对象verificationNumber，将字符数组vc转成字符串verificationNumber.
        String verificationNumber = new String(vc);
        return verificationNumber;
    }
}
