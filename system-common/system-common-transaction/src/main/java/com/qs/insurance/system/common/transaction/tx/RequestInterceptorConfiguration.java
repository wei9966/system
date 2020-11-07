package com.qs.insurance.system.common.transaction.tx;

import com.qs.insurance.system.common.transaction.tx.springcloud.feign.TransactionRestTemplateInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** *
 * @author jhy
 * @since 4.1.0
 */
@Configuration
public class RequestInterceptorConfiguration {

	@Bean
	public RequestInterceptor requestInterceptor() {
		return new TransactionRestTemplateInterceptor();
	}
}
