package com.qs.insurance.upms.feign;

import com.qs.insurance.system.common.core.constant.ServiceNameConstants;
import com.qs.insurance.system.common.core.utils.R;
import com.qs.insurance.upms.common.dto.LoginFormRegDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(contextId = "systemUserFeignService",value = ServiceNameConstants.SYSTEM_UPMS)
public interface SystemUserFeignService {
    @PostMapping(value = "/login/in",produces = "application/json;charset=utf-8")
     R in(@RequestBody LoginFormRegDto loginFormRegDto);
}
