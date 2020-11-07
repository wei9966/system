package com.qs.insurance.system.common.swagger.annotation;

import com.qs.insurance.system.common.swagger.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Create By WeiBin on 2020/9/14 22:47
 * 开启swagger2
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SwaggerAutoConfiguration.class})
public @interface EnableMqmcSwagger2 {
}
