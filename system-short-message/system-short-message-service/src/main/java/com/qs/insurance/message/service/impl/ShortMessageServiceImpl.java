package com.qs.insurance.message.service.impl;

import cn.hutool.http.HttpUtil;
import com.qs.insurance.message.config.ShortMessageConfig;
import com.qs.insurance.message.constant.Constant;
import com.qs.insurance.message.service.ShortMessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service("shortMessageServiceImpl")
@AllArgsConstructor
@Slf4j
public class ShortMessageServiceImpl implements ShortMessageService {

    private ShortMessageConfig shortMessageConfig;
    private StringRedisTemplate stringRedisTemplate;
    private RedisTemplate redisTemplate;

    @Override
    public String login(String username, String password) {
        HashMap<String, String> signIn = this.getHeadMap("signIn");
        String result = null;
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            result = HttpUtil.get(this.getUrl(signIn));
        } else {
            signIn.put("uPhoneNo", username);
            signIn.put("uPassword", password);
            result = HttpUtil.get(this.getUrl(signIn));
            //緩存redis,暂时只能使用我的短信业务
        }
        log.info("登录结果"+result);
        return result;
    }

    @Override
    public String getMessageBalance() {
        //http://api.xunyaosoft.com/zc/zhicode/api.php?code=getLeftNum&uPhoneNo=18800000000&uPassword=abc123
        String result = HttpUtil.get(this.getUrl(this.getHeadMap("getLeftNum")));
        log.info("查询余额结果"+result);
        return result;
    }

    @Override
    public String getMessageCode(String projectName) {
        //http://api.xunyaosoft.com/zc/zhicode/api.php?code=getPhoneNo&projName=简书&uPhoneNo=18800000000&uPassword=abc123
        HashMap<String, String> headMap = this.getHeadMap("getPhoneNo");
        headMap.put("projName", projectName);
        String s = this.stringRedisTemplate.opsForValue().get(Constant.MESSAGE_PHONE_NUMBER_KEY + shortMessageConfig.getUsername());
        if (Optional.ofNullable(s).isPresent()){
            this.stringRedisTemplate.delete(Constant.MESSAGE_PHONE_NUMBER_KEY + shortMessageConfig.getUsername());
        }
        this.stringRedisTemplate.opsForValue().set(Constant.MESSAGE_PHONE_NUMBER_KEY + shortMessageConfig.getUsername(), projectName);
        String result = HttpUtil.get(this.getUrl(headMap));
        log.info("获取手机号结果"+Constant.MESSAGE_PHONE_NUMBER_KEY + shortMessageConfig.getUsername() + result);
        return result;
    }

    @Override
    public String getMessageCodeAgain(String phoneNumber) {
        //http://api.xunyaosoft.com/zc/zhicode/api.php?code=getMsg&uPhoneNo=18800000000&uPassword=abc123&projName=简书&phoneNo=18898765432
        HashMap<String, String> headMap = this.getHeadMap("getMsg");
        headMap.put("phoneNo", phoneNumber);
        headMap.put("projName", this.stringRedisTemplate.opsForValue().get(Constant.MESSAGE_PHONE_NUMBER_KEY + shortMessageConfig.getUsername()));
        String result = HttpUtil.get(this.getUrl(headMap));
        log.info("获取短信具体内容结果"+headMap.get("projName")+result);
        return result;
    }

    private String getUrl(HashMap<String, String> hashMap) {
        StringBuffer stringBuffer = new StringBuffer(shortMessageConfig.getUrl() + "?");
        for (Map.Entry<String, String> str : hashMap.entrySet()) {
            stringBuffer.append(str.getKey() + "=" + str.getValue() + "&");
        }
        return stringBuffer.substring(0, stringBuffer.length() - 1);
    }


    private HashMap<String, String> getHeadMap(String code) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("code", code);
        hashMap.put("uPhoneNo", shortMessageConfig.getUsername());
        hashMap.put("uPassword", shortMessageConfig.getPassword());
        return hashMap;
    }

}
