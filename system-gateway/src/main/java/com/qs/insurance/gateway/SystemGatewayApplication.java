package com.qs.insurance.gateway;

import com.qs.insurance.gateway.annotation.SpringQsBootApplication;
import com.qs.insurance.system.common.dynamic.gateway.annotation.EnableQsDynamicRoute;
import com.qs.insurance.system.common.nacos.QsApplication;
import com.qs.insurance.system.common.nacos.constant.AppConstant;

/**
 * Create By WeiBin on 2020/8/25 22:28
 * @author wb
 */
@SpringQsBootApplication
@EnableQsDynamicRoute
public class SystemGatewayApplication {
    public static void main(String[] args) {
        QsApplication.run(AppConstant.APPLICATION_GATEWAY_NAME,SystemGatewayApplication.class,args);
//        SpringApplication.run(SystemGatewayApplication.class,args);
    }
}
