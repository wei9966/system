package com.qs.insurance.system.common.core.constant.enmus;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @date 2020/4/28
 * 社交登录类型
 */
@Getter
@AllArgsConstructor
public enum LoginTypeEnum {
	/**
	 * 账号密码登录
	 */
	PWD("PWD", "账号密码登录"),

	/**
	 * 验证码登录
	 */
	SMS("SMS", "验证码登录"),

	/**
	 * QQ登录
	 */
	QQ("QQ", "QQ登录"),

	/**
	 * web登录
	 */
	WEB("WEB", "WEB登录"),

	/**
	 * 微信登录
	 */
	WECHAT("WX", "微信登录"),

	CUSTOMER("customer", "客户登录"),

	DOCTOR("doctor", "医生登录");
    /**
	 * 类型
	 */
	private String type;
	/**
	 * 描述
	 */
	private String description;
}
