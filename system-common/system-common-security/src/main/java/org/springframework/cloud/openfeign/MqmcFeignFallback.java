package org.springframework.cloud.openfeign;

import cn.hutool.core.util.StrUtil;
import com.qs.insurance.system.common.core.constant.CommonConstants;
import com.qs.insurance.system.common.core.utils.R;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author jhy
 * <p>
 * fallback 代理处理
 */
@Slf4j
@AllArgsConstructor
public class MqmcFeignFallback<T> implements MethodInterceptor {
	private final Class<T> targetType;
	private final String targetName;
	private final Throwable cause;

	@Nullable
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		Class<?> returnType = method.getReturnType();
		if (R.class != returnType) {
			return null;
		}
		FeignException exception = (FeignException) cause;

		byte[] content = exception.content();

		String str = StrUtil.str(content, StandardCharsets.UTF_8);

		log.error("MqmcFeignFallback:[{}.{}] serviceId:[{}] message:[{}]", targetType.getName()+"--------------", method.getName()+"==============", targetName+">>>>>>>>>>>>>>", str);
		return R.builder().code(CommonConstants.FAIL)
				.msg(str).build();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MqmcFeignFallback<?> that = (MqmcFeignFallback<?>) o;
		return targetType.equals(that.targetType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(targetType);
	}
}
