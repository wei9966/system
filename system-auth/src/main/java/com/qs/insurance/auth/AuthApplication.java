package com.qs.insurance.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Create By WeiBin on 2020/12/5 16:33
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.qs.insurance")
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class,args);
    }
}
