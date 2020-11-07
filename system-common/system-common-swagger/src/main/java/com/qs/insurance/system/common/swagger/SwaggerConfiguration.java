package com.qs.insurance.system.common.swagger;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Create By WeiBin on 2020/11/6 14:31
 * @author WB
 */
@EnableAsync
@Configuration
@AllArgsConstructor
@ComponentScan("com.qs.insurance.system.common.swagger")
public class SwaggerConfiguration {

}
