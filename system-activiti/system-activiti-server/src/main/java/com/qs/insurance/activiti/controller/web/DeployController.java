package com.qs.insurance.activiti.controller.web;

import com.qs.insurance.system.common.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipInputStream;

/**
 * @author xugj<br>
 * @version 1.0<br>
 * @createDate 2019/05/29 17:34 <br>
 * @Description <p> 部署流程、删除流程 </p>
 */

@RestController
@Api(tags = "部署流程、删除流程")
public class DeployController {

    private final RepositoryService repositoryService;

    public DeployController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @PostMapping(path = "deploy")
    @ApiOperation(value = "根据bpmnName部署流程", notes = "根据bpmnName部署流程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bpmnName", value = "设计的流程图名称", dataType = "String", paramType = "query", example = "myProcess")
    })
    public R deploy(@RequestParam("bpmnName") String bpmnName) {

        R R = new R();
        //创建一个部署对象
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment().name("请假流程");
        Deployment deployment = null;
        try {
            deployment = deploymentBuilder
                    .addClasspathResource("processes/" + bpmnName + ".bpmn")
                    .addClasspathResource("processes/" + bpmnName + ".png")
                    .deploy();
        } catch (Exception e) {
            R = R.error("部署失败", e.getMessage());
            e.printStackTrace();
        }

        if (deployment != null) {
            Map<String, String> result = new HashMap<>(2);
            result.put("deployID", deployment.getId());
            result.put("deployName", deployment.getName());
            R = R.success(result, "部署成功");
        }
        return R;
    }

    @PostMapping(path = "deployZIP")
    @ApiOperation(value = "根据ZIP压缩包部署流程", notes = "根据ZIP压缩包部署流程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "zipName", value = "设计的流程图和图片的压缩包名称", dataType = "String", paramType = "query", example = "myProcess")
    })
    public R deployZIP(@RequestParam("file") MultipartFile file) {
        R R = new R();
        Deployment deployment = null;
        try {
            InputStream inputStream = file.getInputStream();
//            InputStream in = this.getClass().getClassLoader().getResourceAsStream("processes/leaveProcess.zip");
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            deployment = repositoryService.createDeployment()
                    //指定zip格式的文件完成部署
                    .name(file.getName())
                    .addZipInputStream(zipInputStream)
                    .deploy();//完成部署
            zipInputStream.close();
        } catch (Exception e) {
            R = R.error("部署失败", e.getMessage());
            // TODO 上线时删除
            e.printStackTrace();
        }
        if (deployment != null) {
            Map<String, String> result = new HashMap<>(2);
            result.put("deployID", deployment.getId());
            result.put("deployName", deployment.getName());
            R = R.success(result, "部署成功");
        }
        return R;
    }

    @PostMapping(path = "deleteProcess")
    @ApiOperation(value = "根据部署ID删除流程", notes = "根据部署ID删除流程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deploymentId", value = "部署ID", dataType = "String", paramType = "query", example = "")
    })
    public R deleteProcess(@RequestParam("deploymentId") String deploymentId) {
        R R = new R();
        /**不带级联的删除：只能删除没有启动的流程，如果流程启动，就会抛出异常*/
        try {
            repositoryService.deleteDeployment(deploymentId);
        } catch (Exception e) {
            R = R.error("删除失败", e.getMessage());
            // TODO 上线时删除
            e.printStackTrace();
        }

        /**级联删除：不管流程是否启动，都能可以删除（emmm大概是一锅端）*/
//        repositoryService.deleteDeployment(deploymentId, true);
        R = R.success("删除成功", null);
        return R;
    }
}
