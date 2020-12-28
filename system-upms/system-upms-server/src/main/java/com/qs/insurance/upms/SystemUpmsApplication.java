package com.qs.insurance.upms;

import com.qs.insurance.system.common.nacos.QsApplication;
import com.qs.insurance.system.common.nacos.constant.AppConstant;
import com.qs.insurance.system.common.swagger.annotation.EnableMqmcSwagger2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Create By WeiBin on 2020/11/7 19:54
 * @author WB
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.qs.insurance")
@EnableDiscoveryClient
@EnableMqmcSwagger2
public class SystemUpmsApplication {
    public static void main(String[] args) {
        QsApplication.run(AppConstant.APPLICATION_UPMS_NAME,SystemUpmsApplication.class,args);
//        SpringApplication.run(SystemUpmsApplication.class,args);
    }
}
