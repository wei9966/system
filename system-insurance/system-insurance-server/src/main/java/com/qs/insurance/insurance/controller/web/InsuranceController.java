package com.qs.insurance.insurance.controller.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api(tags = "测试返回结果")
public class InsuranceController {


    @GetMapping("/str")
    @ApiOperation("测试返回结果str")
    public String getTestResult(){
        return "这是一条没有用的消息";
    }
}
