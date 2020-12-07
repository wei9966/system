package com.qs.insurance.upms.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginFormRegDto {
    private String userName;
    private String password;
}
