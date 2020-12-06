package com.qs.insurance.upms.utils;

import com.qs.insurance.upms.entity.SystemUser;
import org.apache.shiro.SecurityUtils;

public class AppSecurityUtils {
    public static SystemUser getUser() {
        return (SystemUser) SecurityUtils.getSubject().getPrincipal();
    }

    public static Long getUserId() {
        return getUser().getId();
    }
}
