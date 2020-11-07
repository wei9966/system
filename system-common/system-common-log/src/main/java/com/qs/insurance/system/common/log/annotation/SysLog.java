package com.qs.insurance.system.common.log.annotation;

import java.lang.annotation.*;

/**
 *
 * @Author jhy
 * @Date  2020/5/5 7:18 下午
 * @Description :操作日志注解
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

	/**
	 * 描述
	 *
	 * @return {String}
	 */
	String value();
}
