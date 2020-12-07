package com.qs.insurance.upms.controller.feign;

import com.qs.insurance.upms.entity.SysUserToken;
import com.qs.insurance.upms.entity.SystemUser;
import com.qs.insurance.upms.service.ShiroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/shiro")
@AllArgsConstructor
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
