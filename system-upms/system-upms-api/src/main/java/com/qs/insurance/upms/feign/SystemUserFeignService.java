package com.qs.insurance.upms.feign;

import com.qs.insurance.system.common.core.constant.ServiceNameConstants;
import com.qs.insurance.system.common.core.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(contextId = "SystemUserFeignService",value = ServiceNameConstants.SYSTEM_UPMS)
public interface SystemUserFeignService {
    @PostMapping("/login/in")
     R in(@RequestParam("userName") String username, @RequestParam("password") String password);
}
