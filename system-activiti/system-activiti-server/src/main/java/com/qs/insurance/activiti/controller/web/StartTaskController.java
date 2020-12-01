package com.qs.insurance.activiti.controller.web;

import com.qs.insurance.system.common.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By WeiBin on 2020/10/30 19:33
 *
 * @author WB
 */
@RestController
@AllArgsConstructor
@RequestMapping("/start/task")
@Api(tags = "启动任务相关接口")
public class StartTaskController {

    private RuntimeService runtimeService;

    @PostMapping("/many")
    @ApiOperation("启动多人任务分配")
    public R startManyPeople(
            @ApiParam(required = true, value = "流程key") @RequestParam String processesKey,
            @ApiParam(required = true, value = "用户id") @RequestBody List<String> userIds) {

        Map<String, Object> map = new HashMap<>(2);
        StringBuffer stringBuffer = new StringBuffer();
        userIds.forEach(s -> {
            stringBuffer.append(s).append(",");
        });
        String result = stringBuffer.substring(0, stringBuffer.length() - 1);
        System.out.println("用户组id" + result);
        map.put("userIds", result);
        ProcessInstance processInstance = null;
        try {
            processInstance = runtimeService.startProcessInstanceByKey(processesKey, map);
            return new R<>().success(processInstance.getProcessVariables(), "启动成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new R<>().error("提交失败", e.getMessage());
        }
    }


}
