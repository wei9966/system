package com.qs.insurance.system.common.data.tenant;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jhy
 * @date 2020/4/28
 * feign 租户信息拦截
 */
@Configuration
public class MqmcFeignTenantConfiguration {
	@Bean
	public RequestInterceptor mqmcFeignTenantInterceptor() {
		return new MqmcFeignTenantInterceptor();
	}
}
