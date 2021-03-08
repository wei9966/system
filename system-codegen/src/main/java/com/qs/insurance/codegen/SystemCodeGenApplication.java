package com.qs.insurance.codegen;

import com.qs.insurance.system.common.nacos.QsApplication;
import com.qs.insurance.system.common.nacos.constant.AppConstant;
import com.qs.insurance.system.common.swagger.annotation.EnableMqmcSwagger2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 */
@EnableMqmcSwagger2
@EnableFeignClients(basePackages = "com.qs.insurance")
@SpringBootApplication
@EnableDiscoveryClient
//@EnableMqmcResourceServer(details = true)
public class SystemCodeGenApplication {

	public static void main(String[] args) {
		QsApplication.run(AppConstant.APPLICATION_CODEGEN_NAME,SystemCodeGenApplication.class,args);
	}
}
