package com.qs.insurance.message.controller;

import com.qs.insurance.message.service.ShortMessageService;
import com.qs.insurance.system.common.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@AllArgsConstructor
@Api(value = "聚码短信接口",tags = "聚码短信接口")
public class ShortMessageController {

    private final ShortMessageService shortMessageService;
    @GetMapping("/login")
    @ApiOperation("登录")
    public R login(@RequestParam(value = "username",required = false) String username,
                   @RequestParam(value = "password",required = false)String password){
            this.shortMessageService.login(username,password);
        return new R<>("登录成功");
    }
    /**
     * 批量业务短信余量查询
     * http://api.xunyaosoft.com/zc/zhicode/api.php?code=getLeftNum&uPhoneNo=18800000000&uPassword=abc123
     */
    @ApiOperation("批量业务短信余量查询")
    @GetMapping("/get/balance")
    public R getMessageBalance(){
        return new R<>(this.shortMessageService.getMessageBalance());
    }

    /**
     * 获取一个手机号（指定号码接码/二次接码 请见“获取短信”的API）
     * http://api.xunyaosoft.com/zc/zhicode/api.php?code=getPhoneNo&projName=简书&uPhoneNo=18800000000&uPassword=abc123
     * @return
     */
    @ApiOperation("获取一个手机号")
    @GetMapping("/get/code")
    public R getMessageCode(@RequestParam("projectName") String projectName){
        return new R<>(this.shortMessageService.getMessageCode(projectName));
    }

    /**
     * 获取短信/指定号码接码/二次接码（获取前要先往以上获取的手机号发短信）
     * http://api.xunyaosoft.com/zc/zhicode/api.php?code=getMsg&uPhoneNo=18800000000&uPassword=abc123&projName=简书&phoneNo=18898765432
     * @return
     */
    @ApiOperation("获取短信/指定号码接码/二次接码")
    @GetMapping("/get/again/code")
    public R getMessageCodeAgain(@RequestParam("phoneNumber")String phoneNumber){
        return new R<>(this.shortMessageService.getMessageCodeAgain(phoneNumber));
    }
}
