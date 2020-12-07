package com.qs.insurance.upms.feign;

import com.qs.insurance.system.common.core.constant.ServiceNameConstants;
import com.qs.insurance.upms.entity.SysUserToken;
import com.qs.insurance.upms.entity.SystemUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Component
@FeignClient(contextId = "systemShiroFeignServie",value = ServiceNameConstants.SYSTEM_UPMS)
public interface SystemShiroFeignServie {
    @PostMapping("/shiro/getUserPermissions")
    Set<String> getUserPermissions(@RequestParam("userId")long userId);
    @PostMapping("/shiro/queryByToken")
    SysUserToken queryByToken(@RequestParam("token")String token);
    @PostMapping("/shiro/queryUser")
    SystemUser queryUser(@RequestParam("userId") Long userId);
}
