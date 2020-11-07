package com.qs.insurance.codegen;

import com.qs.insurance.system.common.swagger.annotation.EnableMqmcSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author jhy
 */
@EnableMqmcSwagger2
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
//@EnableMqmcResourceServer(details = true)
public class SystemCodeGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemCodeGenApplication.class, args);
	}
}
