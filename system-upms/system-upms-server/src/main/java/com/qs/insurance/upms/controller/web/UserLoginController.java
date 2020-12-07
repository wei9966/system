package com.qs.insurance.upms.controller.web;

import com.qs.insurance.system.common.core.utils.MapUtils;
import com.qs.insurance.system.common.core.utils.R;
import com.qs.insurance.system.common.security.utils.AppSecurityUtils;
import com.qs.insurance.upms.common.dto.LoginFormRegDto;
import com.qs.insurance.upms.service.SysUserTokenService;
import com.qs.insurance.upms.service.SystemUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
        try {
            return systemUserService.loginIn(loginFormRegDto.getUserName(),loginFormRegDto.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return new R().error(e.getMessage());
        }
    }

    @PostMapping("/out")
    @ApiOperation("退出登錄")
    public  R out(){
        sysUserTokenService.logout(AppSecurityUtils.getUserId());
        return new R<>("退出成功");
    }

    @PostMapping("/in/in")
    public Map inMap(@RequestParam("in") String in){
        return new MapUtils().put("abc","eff").put("in",in);
    }
}
