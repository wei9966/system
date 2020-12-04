package com.qs.insurance.upms;

import com.qs.insurance.system.common.swagger.annotation.EnableMqmcSwagger2;
import org.springframework.boot.SpringApplication;
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
        SpringApplication.run(SystemUpmsApplication.class,args);
    }
}
