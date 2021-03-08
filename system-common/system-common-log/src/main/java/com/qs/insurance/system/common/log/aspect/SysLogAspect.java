package com.qs.insurance.system.common.log.aspect;

import com.qs.insurance.system.common.log.annotation.SysLog;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationEventPublisher;

/**
 * 操作日志使用spring event异步入库
 *
 */
@Slf4j
@Aspect
@AllArgsConstructor
public class SysLogAspect {
	private final ApplicationEventPublisher publisher;

	@SneakyThrows
	@Around("@annotation(sysLog)")
	public Object around(ProceedingJoinPoint point, SysLog sysLog) {
		String strClassName = point.getTarget().getClass().getName();
		String strMethodName = point.getSignature().getName();
		log.debug("[类名]:{},[方法]:{}", strClassName, strMethodName);

//		com.rongda.system.upms.model.SysLog logVo = SysLogUtils.getSysLog();
//		logVo.setTitle(sysLog.value());
		// 发送异步日志事件
		Long startTime = System.currentTimeMillis();
		try {
			Object obj = point.proceed();
			Long endTime = System.currentTimeMillis();
//			logVo.setTime(endTime - startTime);
//			publisher.publishEvent(new SysLogEvent(logVo));
			return obj;
		}catch (Exception e){
//			logVo.setException(e.getMessage());
			Long endTime = System.currentTimeMillis();
//			logVo.setTime(endTime - startTime);
//			publisher.publishEvent(new SysLogEvent(logVo));
			throw e;
		}
	}

}
