package com.qs.insurance.insurance;


import com.qs.insurance.system.common.nacos.QsApplication;
import com.qs.insurance.system.common.nacos.constant.AppConstant;
import com.qs.insurance.system.common.swagger.annotation.EnableMqmcSwagger2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableMqmcSwagger2
public class SystemInsuranceApplication {
    public static void main(String[] args) {
        QsApplication.run(AppConstant.APPLICATION_INSURANCE_NAME,SystemInsuranceApplication.class,args);
    }
}
