package com.qs.insurance.system.common.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties("shiro.filter")
public class FilterConfig {
    private List<String> url;
}
