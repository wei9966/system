package com.qs.insurance.system.common.log.event;

import com.qs.insurance.system.common.log.annotation.SysLog;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author jhy
 * 系统日志事件
 */
@Getter
@AllArgsConstructor
public class SysLogEvent {
	private final SysLog sysLog;
}
