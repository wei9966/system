package com.qs.insurance.upms.controller.web;

import com.qs.insurance.system.common.core.utils.R;
import com.qs.insurance.upms.common.dto.LoginFormRegDto;
import com.qs.insurance.upms.service.SysUserTokenService;
import com.qs.insurance.upms.service.SystemUserService;
import com.qs.insurance.upms.utils.AppSecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
@Api(tags = "登录相关")
public class UserLoginController {
    private  final SystemUserService systemUserService;
    private final SysUserTokenService sysUserTokenService;
    @PostMapping("/in")
    @ApiOperation("登录")
    public R in(@RequestBody LoginFormRegDto loginFormRegDto){
        return systemUserService.loginIn(loginFormRegDto.getUserName(),loginFormRegDto.getPassword());
    }

    @PostMapping("/out")
    @ApiOperation("退出登錄")
    public  R out(){
        sysUserTokenService.logout(AppSecurityUtils.getUserId());
        return new R<>("退出成功");
    }
}
