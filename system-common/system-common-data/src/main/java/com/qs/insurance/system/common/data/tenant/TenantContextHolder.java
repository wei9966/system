package com.qs.insurance.system.common.data.tenant;

import com.alibaba.ttl.TransmittableThreadLocal;
import lombok.experimental.UtilityClass;

/**
 * @author jhy
 * @date 2020/4/28
 * 租户工具类
 */
@UtilityClass
public class TenantContextHolder {

	private final ThreadLocal<Integer> THREAD_LOCAL_TENANT = new TransmittableThreadLocal<>();


	/**
	 * TTL 设置租户ID
	 *
	 * @param tenantId
	 */
	void setTenantId(Integer tenantId) {
		THREAD_LOCAL_TENANT.set(tenantId);
	}

	/**
	 * 获取TTL中的租户ID
	 *
	 * @return
	 */
	public Integer getTenantId() {
		return THREAD_LOCAL_TENANT.get();
	}

	public void clear() {
		THREAD_LOCAL_TENANT.remove();
	}
}
