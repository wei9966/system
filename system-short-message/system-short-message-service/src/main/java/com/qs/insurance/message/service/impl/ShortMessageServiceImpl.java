package com.qs.insurance.message.service.impl;

import cn.hutool.http.HttpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qs.insurance.message.config.ShortMessageConfig;
import com.qs.insurance.message.constant.ShortMessageRedisConstant;
import com.qs.insurance.message.dao.ShortMessageMapper;
import com.qs.insurance.message.entity.ShortMessage;
import com.qs.insurance.message.entity.ShortMessageContent;
import com.qs.insurance.message.entity.ShortMessageLoginRecord;
import com.qs.insurance.message.service.ShortMessageContentService;
import com.qs.insurance.message.service.ShortMessageLoginRecordService;
import com.qs.insurance.message.service.ShortMessageService;
import com.qs.insurance.system.common.core.utils.MapUtils;
import com.qs.insurance.system.common.security.utils.AppSecurityUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service("shortMessageServiceImpl")
@AllArgsConstructor
@Slf4j
public class ShortMessageServiceImpl extends ServiceImpl<ShortMessageMapper, ShortMessage> implements ShortMessageService {
    private ShortMessageMapper shortMessageMapper;
    private final ShortMessageConfig shortMessageConfig;
    private final StringRedisTemplate stringRedisTemplate;
    private final ShortMessageLoginRecordService shortMessageLoginRecordService;
    private final ShortMessageContentService shortMessageContentService;

    @Override
    public Map login(String username, String password) {
        MapUtils mapUtils = new MapUtils();
        String result=null;
        //登录先走我们的逻辑登录，再走远程的
        try {
            ShortMessage shortMessageRecord = this.checkFirstLoginAndSave(username);
            if (Optional.ofNullable(shortMessageRecord).isPresent()){
                HashMap<String, String> signIn = this.getHeadMap("signIn");
                if (shortMessageRecord.getPhoneNumber().equals(signIn.get("uPhoneNo"))){
                    result = HttpUtil.get(this.getUrl(signIn));
                }
            }else{
                //保存起来
                HashMap<String, String> signIn =new HashMap<>();;
                signIn.put("code","signIn");
                shortMessageRecord=new ShortMessage();
                shortMessageRecord.setPhoneNumber(username);
                shortMessageRecord.setPassword(password);
                shortMessageRecord.setUserId(AppSecurityUtils.getUserId());
                this.shortMessageMapper.insert(shortMessageRecord);
                //緩存redis,暂时只能使用我的短信业务
                signIn.put("uPhoneNo", username);
                signIn.put("uPassword", password);
                result = HttpUtil.get(this.getUrl(signIn));
            }
            //保存登录记录
            ShortMessageLoginRecord shortMessageLoginRecord = new ShortMessageLoginRecord();
            shortMessageLoginRecord.setLoginResult(result);
            shortMessageLoginRecord.setMessageId(shortMessageRecord.getId());
            shortMessageLoginRecordService.save(shortMessageLoginRecord);
            log.info("登录结果" + result);
        } catch (Exception e) {
            throw new RuntimeException("登录失败，用户名或密码错误");
        }
        return mapUtils.put("result",result);
    }

    @Override
    public String getMessageBalance() {
        //http://api.xunyaosoft.com/zc/zhicode/api.php?code=getLeftNum&uPhoneNo=18800000000&uPassword=abc123
        String result = HttpUtil.get(this.getUrl(this.getHeadMap("getLeftNum")));
        log.info("查询余额结果" + result);
        return result;
    }

    @Override
    public String getMessageCode(String projectName) {
        //http://api.xunyaosoft.com/zc/zhicode/api.php?code=getPhoneNo&projName=简书&uPhoneNo=18800000000&uPassword=abc123
        HashMap<String, String> headMap = this.getHeadMap("getPhoneNo");
        headMap.put("projName", projectName);
        String s = this.stringRedisTemplate.opsForValue().get(ShortMessageRedisConstant.MESSAGE_PHONE_NUMBER_KEY + shortMessageConfig.getUsername());
        if (Optional.ofNullable(s).isPresent()) {
            this.stringRedisTemplate.delete(ShortMessageRedisConstant.MESSAGE_PHONE_NUMBER_KEY + shortMessageConfig.getUsername());
        }
        this.stringRedisTemplate.opsForValue().set(ShortMessageRedisConstant.MESSAGE_PHONE_NUMBER_KEY + shortMessageConfig.getUsername(), projectName);
        String result = HttpUtil.get(this.getUrl(headMap));
        //检验项目名称和手机号同时查找，如果存在就不新增，只做修改
        ShortMessageContent one = this.shortMessageContentService.getOne(Wrappers.<ShortMessageContent>query().lambda()
                .eq(ShortMessageContent::getPhoneNum, shortMessageConfig.getUsername()).eq(ShortMessageContent::getProjectName, projectName));
        ShortMessageContent shortMessageContent = new ShortMessageContent();
        if (!Optional.ofNullable(one).isPresent()){
            shortMessageContent.setPhoneNum(result);
            shortMessageContent.setProjectName(projectName);
            shortMessageContent.setMessageId(this.shortMessageMapper.selectOne(Wrappers.<ShortMessage>query().lambda().eq(ShortMessage::getPhoneNumber, shortMessageConfig.getUsername())).getId());
            shortMessageContentService.save(shortMessageContent);
        }else{
             shortMessageContent=one;
            shortMessageContentService.updateById(shortMessageContent);
        }
        log.info("保存后的结果" + shortMessageContent);
        return result;
    }

    @Override
    public String getMessageCodeAgain(String phoneNumber) {
        //http://api.xunyaosoft.com/zc/zhicode/api.php?code=getMsg&uPhoneNo=18800000000&uPassword=abc123&projName=简书&phoneNo=18898765432
        HashMap<String, String> headMap = this.getHeadMap("getMsg");
        headMap.put("phoneNo", phoneNumber);
        headMap.put("projName", this.stringRedisTemplate.opsForValue().get(ShortMessageRedisConstant.MESSAGE_PHONE_NUMBER_KEY + shortMessageConfig.getUsername()));
        String result = HttpUtil.get(this.getUrl(headMap));
        LambdaQueryWrapper<ShortMessageContent> lambda = Wrappers.<ShortMessageContent>query().lambda();
        lambda.eq(ShortMessageContent::getPhoneNum,phoneNumber);
        ShortMessageContent content = this.shortMessageContentService.getOne(lambda);
        //如果收到验证码 更新内容
        if (!result.contains("尚未收到短信")){
            content.setCodeContent(result);
            this.shortMessageContentService.updateById(content);
        }
        log.info("获取短信具体内容结果" + headMap.get("projName") + result);
        return result;
    }

    private String getUrl(HashMap<String, String> hashMap) {
        StringBuffer stringBuffer = new StringBuffer(shortMessageConfig.getUrl() + "?");
        for (Map.Entry<String, String> str : hashMap.entrySet()) {
            stringBuffer.append(str.getKey() + "=" + str.getValue() + "&");
        }
        return stringBuffer.substring(0, stringBuffer.length() - 1);
    }

    /**
     * 通用请求头设置
     * @param code 请求方法code码
     * @return map对象
     */
    private HashMap<String, String> getHeadMap(String code) {
        ShortMessage shortMessage = this.getOne(Wrappers.<ShortMessage>query().lambda().eq(ShortMessage::getUserId, AppSecurityUtils.getUserId()));
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("code", code);
        hashMap.put("uPhoneNo", shortMessage.getPhoneNumber());
        hashMap.put("uPassword", shortMessage.getPassword());
        return hashMap;
    }


    private ShortMessage checkFirstLoginAndSave(String phone) {
        LambdaQueryWrapper<ShortMessage> lambda = Wrappers.<ShortMessage>query().lambda();
        lambda.eq(ShortMessage::getPhoneNumber, phone);
        ShortMessage shortMessageRecord = this.shortMessageMapper.selectOne(lambda);
        if (Optional.ofNullable(shortMessageRecord).isPresent()){
            return  shortMessageRecord;
        }
        return null;
    }
}
