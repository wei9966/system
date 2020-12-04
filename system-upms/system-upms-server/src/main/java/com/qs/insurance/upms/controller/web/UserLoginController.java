package com.qs.insurance.upms.controller.web;

import com.qs.insurance.system.common.core.utils.R;
import com.qs.insurance.upms.entity.SystemUser;
import com.qs.insurance.upms.service.SystemUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
@Api(tags = "登录相关")
public class UserLoginController {
    private  final SystemUserService systemUserService;

    @PostMapping("/in")
    @ApiOperation("登录")
    public R in(@RequestParam("userName") String username, @RequestParam("password") String password){
        SystemUser systemUser1=systemUserService.loginIn(username,password);
        return new R<>(systemUser1);
    }

    @PostMapping("/out")
    @ApiOperation("退出登錄")
    public  R out(){
        return new R();
    }
}
