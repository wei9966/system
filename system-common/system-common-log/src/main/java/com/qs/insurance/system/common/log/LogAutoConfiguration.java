package com.qs.insurance.system.common.log;

import com.qs.insurance.system.common.log.aspect.SysLogAspect;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *
 * @Author jhy
 * @Date  2020/5/5 7:20 下午
 * @Description :日志自动配置
 *
 */
@EnableAsync
@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
public class LogAutoConfiguration {
//	private final RemoteLogService remoteLogService;

//	@Bean
//	public SysLogListener sysLogListener() {
//		return new SysLogListener(remoteLogService);
//	}


	@Bean
	public SysLogAspect sysLogAspect(ApplicationEventPublisher publisher) {
		return new SysLogAspect(publisher);
	}
}
