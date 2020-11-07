package com.qs.insurance.system.common.core.utils;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import feign.form.util.CharsetUtil;

/**
 * @author jhy
 * @program his
 * @description 正广兴api接口
 * @create 2020-04-09 14:10
 **/
public class ZgxApiUtils {
    public static final String DOMAIN = "http://www.zgx131.com";

    public static final String MMT_DOMAIN = "http://dev.api.supermm.me";

    public static final String MMT_DOMAIN_PROD = "http://api.supermm.me";

    /**
     * 获取短信验证码接口调用 token
     * @return
     */
    public static String getApiToken(){
        String getTokenUrl = MMT_DOMAIN_PROD + "/ext/login?appid=100001&sign=a9740838c7a130a7ac5912c69e83101e";
        String tokenStr = HttpUtil.post(getTokenUrl, "");

        if (tokenStr != null) {
            JSON json = JSONUtil.parse(tokenStr);

            if ("000".equals(json.getByPath("code") + "")){
                return json.getByPath("data.data.token")+ "";
            }
        }
        return null;
    }

    /**
     * 发送短信
     * @param token
     * @param phone
     * @param content
     * @return
     */
    public static boolean sendSms(String token, String phone, String content){
        StringBuilder getSmsUrl = new StringBuilder(MMT_DOMAIN_PROD + "/ext/sms/send?appId=100001&token=");
        getSmsUrl.append(token);
        getSmsUrl.append("&phone=");
        getSmsUrl.append(phone);
        getSmsUrl.append("&content=");
        getSmsUrl.append(HttpUtil.encode(content, CharsetUtil.UTF_8));
        String smsStr = HttpRequest.post(getSmsUrl.toString()).execute().body();
        if (smsStr != null){
            JSON json =  JSONUtil.parse(smsStr);
            return "000".equals(json.getByPath("code") + "");
        }
        return false;
    }
}
