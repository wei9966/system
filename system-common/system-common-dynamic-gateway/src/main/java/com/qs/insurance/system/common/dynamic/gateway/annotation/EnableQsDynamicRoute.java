package com.qs.insurance.system.common.dynamic.gateway.annotation;

import com.qs.insurance.system.common.dynamic.gateway.configuration.DynamicRouteAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Create By WeiBin on 2020/8/25 23:50
 * 开启动态路由
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(DynamicRouteAutoConfiguration.class)
public @interface EnableQsDynamicRoute {
}
