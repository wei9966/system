package com.qs.insurance.gateway;

import com.qs.insurance.gateway.annotation.SpringQsBootApplication;
import com.qs.insurance.system.common.dynamic.gateway.annotation.EnableQsDynamicRoute;
import org.springframework.boot.SpringApplication;

/**
 * Create By WeiBin on 2020/8/25 22:28
 * @author wb
 */
@SpringQsBootApplication
@EnableQsDynamicRoute
public class SystemGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemGatewayApplication.class);
    }
}
