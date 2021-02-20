package com.qs.insurance.activiti;

import com.qs.insurance.system.common.nacos.QsApplication;
import com.qs.insurance.system.common.nacos.constant.AppConstant;
import com.qs.insurance.system.common.swagger.annotation.EnableMqmcSwagger2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 工作流相關服務
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.qs.insurance")
@EnableDiscoveryClient
@EnableMqmcSwagger2
public class ActivitiApplication {
    public static void main(String[] args) {
        QsApplication.run(AppConstant.APPLICATION_ACTIVITI_NAME,ActivitiApplication.class,args);
    }
}
