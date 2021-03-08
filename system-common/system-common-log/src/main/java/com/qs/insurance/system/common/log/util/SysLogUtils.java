package com.qs.insurance.system.common.log.util;

import cn.hutool.core.util.URLUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.HttpUtil;
import com.qs.insurance.system.common.core.constant.CommonConstants;
import com.qs.insurance.upms.entity.SysLog;
import lombok.experimental.UtilityClass;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 系统日志工具类
 *
 */
@UtilityClass
public class SysLogUtils {
	public SysLog getSysLog() {
		HttpServletRequest request = ((ServletRequestAttributes) Objects
				.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
		SysLog sysLog = new SysLog();
//		sysLog.setCreateBy(Objects.requireNonNull(getUsername()));
		sysLog.setType(CommonConstants.STATUS_NORMAL);
		sysLog.setRemoteAddr(ServletUtil.getClientIP(request));
		sysLog.setRequestUri(URLUtil.getPath(request.getRequestURI()));
		sysLog.setMethod(request.getMethod());
		sysLog.setUserAgent(request.getHeader("user-agent"));
		sysLog.setParams(HttpUtil.toParams(request.getParameterMap()));
//		sysLog.setServiceId(getClientId());
//		sysLog.setTenantId(Constant.LOG_TYPE_NORMAL);
		return sysLog;
	}


	/**
	 * 获取用户名称
	 *
	 * @return username
	 */
//	private String getUsername() {
//		SecurityManager securityManager = System.getSecurityManager();
//		if (authentication == null) {
//			return null;
//		}
//		return authentication.getName();
//	}

}
