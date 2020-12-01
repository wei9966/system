package com.qs.insurance.activiti.controller.web;

import com.qs.insurance.common.model.Holiday;
import com.qs.insurance.system.common.core.utils.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By WeiBin on 2020/10/30 18:36
 * 请假流程相关
 *
 * @author WB
 */
@RestController
@RequestMapping("/holiday")
@AllArgsConstructor
public class HolidayController {
    /**
     * 任务相关服务
     */
    private TaskService taskService;
    /**
     * 实例相关服务
     */
    private RuntimeService runtimeService;
    @PostMapping(path = "/start")
    @ApiOperation(value = "根据流程key启动流程", notes = "每一个流程有对应的一个key这个是某一个流程内固定的写在bpmn内的")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "processKey", value = "流程key", dataType = "String", paramType = "query", example = "")
    })
    public R start(@RequestParam("processKey") String processKey,
                   @RequestBody Holiday holiday) {
        HashMap<String, Object> variables = new HashMap<>(1);
        variables.put("holiday", holiday);
        R R = new R();
        ProcessInstance instance = null;
        try {
            instance = runtimeService
                    .startProcessInstanceByKey(processKey, variables);
        } catch (Exception e) {
            R = R.error("启动失败", e.getMessage());
            e.printStackTrace();
        }

        if (instance != null) {
            Map<String, String> result = new HashMap<>(2);
            // 流程实例ID
            result.put("processID", instance.getId());

            // 流程定义ID
            result.put("processDefinitionKey", instance.getProcessDefinitionId());
            R = R.success(result,"启动成功");
        }
        return R;
    }


    @PostMapping(path = "findTaskByAssignee")
    @ApiOperation(value = "根据流程assignee查询当前人的个人任务", notes = "根据流程assignee查询当前人的个人任务")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "assignee", value = "代理人（当前用户）", dataType = "String", paramType = "query", example = ""),
    })
    public R findTaskByAssignee(@RequestParam("assignee") String assignee) {
        R R = new R();

        //创建任务查询对象
        List<Task> taskList;
        try {
            taskList = taskService.createTaskQuery()
                    //指定个人任务查询
                    .taskAssignee(assignee)
                    .list();
        } catch (Exception e) {
            R = R.error("查询失败", e.getMessage());
            e.printStackTrace();
            return R;
        }

        if (taskList != null && taskList.size() > 0) {
            List<Map<String, String>> resultList = new ArrayList<>();
            for (Task task : taskList) {
                Map<String, String> resultMap = new HashMap<>(7);
                /* 任务ID */
                resultMap.put("taskID", task.getId());

                /* 任务名称 */
                resultMap.put("taskName", task.getName());

                /* 任务的创建时间 */
                resultMap.put("taskCreateTime", task.getCreateTime().toString());

                /* 任务的办理人 */
                resultMap.put("taskAssignee", task.getAssignee());

                /* 流程实例ID */
                resultMap.put("processInstanceId", task.getProcessInstanceId());

                /* 执行对象ID */
                resultMap.put("executionId", task.getExecutionId());

                /* 流程定义ID */
                resultMap.put("processDefinitionId", task.getProcessDefinitionId());
                resultList.add(resultMap);
            }
            R = R.success(resultList,"查询成功" );
        } else {
            R = R.success(null,"查询成功");
        }

        return R;
    }

    @PostMapping(path = "/user/completeTask")
    @ApiOperation(value = "请假人完成任务", notes = "完成任务，任务进入下一个节点")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "taskId", value = "任务ID", dataType = "String", paramType = "query", example = ""),
            @ApiImplicitParam(name = "days", value = "请假天数", dataType = "int", paramType = "query", example = ""),
    })
    public R completeTask(@RequestParam("taskId") String taskId,
                                    @RequestParam(value = "days", required = false) int days) {

        R R = new R();
        try {
            HashMap<String, Object> variables = new HashMap<>(1);
            variables.put("days", days);
            taskService.complete(taskId, variables);
        } catch (Exception e) {
            R = R.error("提交失败", e.getMessage());
            e.printStackTrace();
            return R;
        }
        R = R.error("提交成功", taskId);
        return R;
    }

    @PostMapping(path = "/leader/completeTask")
    @ApiOperation(value = "上级领导审批请假人", notes = "完成任务，任务进入下一个节点")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "taskId", value = "任务ID", dataType = "String", paramType = "query", example = "")
    })
    public R leaderCompleteTask(@RequestParam("taskId") String taskId) {

        R R = new R();
        try {
            taskService.complete(taskId);
        } catch (Exception e) {
            R = R.error("提交失败", e.getMessage());
            e.printStackTrace();
            return R;
        }
        R = R.success(taskId,"完成成功" );
        return R;
    }
}
