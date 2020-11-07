package com.qs.insurance.system.common.data.tenant;

import com.qs.insurance.system.common.core.constant.CommonConstants;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jhy
 * @date 2020/4/28
 */
@Slf4j
public class MqmcFeignTenantInterceptor implements RequestInterceptor {
	@Override
	public void apply(RequestTemplate requestTemplate) {
		if (TenantContextHolder.getTenantId() == null) {
			log.error("TTL 中的 租户ID为空，feign拦截器 >> 增强失败");
			return;
		}
		requestTemplate.header(CommonConstants.TENANT_ID, TenantContextHolder.getTenantId().toString());
	}
}
