package com.qs.insurance.system.common.log.event;

import com.qs.insurance.system.common.log.annotation.SysLog;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * @author jhy
 * 异步监听日志事件
 */
@Slf4j
@AllArgsConstructor
public class SysLogListener {
//	private final RemoteLogService remoteLogService;

	@Async
	@Order
	@EventListener(SysLogEvent.class)
	public void saveSysLog(SysLogEvent event) {
		SysLog sysLog = event.getSysLog();
//		remoteLogService.saveLog(sysLog, SecurityConstants.FROM_IN);
	}
}
