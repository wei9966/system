package com.qs.insurance.message;

import com.qs.insurance.system.common.swagger.annotation.EnableMqmcSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.qs.insurance")
@EnableDiscoveryClient
@EnableMqmcSwagger2
public class ShortMessageApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShortMessageApplication.class,args);
    }
}
