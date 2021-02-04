package com.qs.insurance.upms.controller.feign;

import com.qs.insurance.upms.entity.SysUserToken;
import com.qs.insurance.upms.entity.SystemUser;
import com.qs.insurance.upms.service.ShiroService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/shiro")
@AllArgsConstructor
@Api(value = "安全相关feign请求", tags = "安全相关feign请求")
public class SystemShiroFeignController {
    private final ShiroService shiroService;
    /**
     * 获取用户权限列表
     */
    @PostMapping("/getUserPermissions")
    Set<String> getUserPermissions(@RequestParam("userId")long userId){
       return shiroService.getUserPermissions(userId);
    }
    @PostMapping("/queryByToken")
    SysUserToken queryByToken(@RequestParam("token")String token){
        return shiroService.queryByToken(token);
    }

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    @PostMapping("/queryUser")
    SystemUser queryUser(@RequestParam("userId") Long userId){
        return shiroService.queryUser(userId);
    }
}
