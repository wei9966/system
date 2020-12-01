package com.qs.insurance.message.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "short.message")
@Data
public class ShortMessageConfig {
    private String username;
    private String password;
    private String url;
}
