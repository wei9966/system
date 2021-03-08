package com.qs.insurance.system.common.data.util;

import cn.hutool.core.util.StrUtil;
import com.qs.insurance.system.common.core.constant.CommonConstants;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @program mqmc-marged
 * @description 验证码校验工具类
 * @create 2020-05-29 10:42
 **/
public class ValidateCodeUtil {

    /**
     */
    public static boolean validateCode(RedisTemplate redisTemplate, String code, String phone) {
        String key = CommonConstants.WX_PHONE_CODE_KEY + phone;
        if (!redisTemplate.hasKey(key)) {
            return false;
        }
        Object codeObj = redisTemplate.opsForValue().get(key);

        if (codeObj == null) {
            return false;
        }
        String savedCode = codeObj.toString();
        if (StrUtil.isBlank(savedCode)) {
            redisTemplate.delete(key);
            return false;
        }
        if (!StrUtil.equals(savedCode, code)) {
            return false;
        }
        return true;
    }
}
