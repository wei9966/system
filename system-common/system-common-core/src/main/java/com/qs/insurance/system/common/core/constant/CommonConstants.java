package com.qs.insurance.system.common.core.constant;

/**
 * @date 2020/4/28
 */
public interface CommonConstants {
	/**
	 * header 中租户ID
	 */
	String TENANT_ID = "TENANT_ID";
	/**
	 * 删除
	 */
	String STATUS_DEL = "1";
	/**
	 * 正常
	 */
	Byte STATUS_NORMAL = 0;

	/**
	 * 锁定
	 */
	Byte STATUS_LOCK = 9;

	/**
	 * 菜单
	 */
	String MENU = "0";

	/**
	 * 编码
	 */
	String UTF8 = "UTF-8";

	/**
	 * 前端工程名
	 */
	String FRONT_END_PROJECT = "qs-ui";

	/**
	 * 后端工程名
	 */
	String BACK_END_PROJECT = "qs";

	/**
	 * 路由存放
	 */
	String ROUTE_KEY = "gateway_route_key";

	/**
	 * spring boot admin 事件key
	 */
	String EVENT_KEY = "event_key";

	/**
	 * 验证码前缀
	 */
	String DEFAULT_CODE_KEY = "MQMC_DEFAULT_CODE_KEY_";

	/**
	 * 成功标记
	 */
	Integer SUCCESS = 1;
	/**
	 * 失败标记
	 */
	Integer FAIL = 0;
	/**
	 * 微信未找到用户返回状态码
	 */
	Integer WX_FAIL = 1002;
	/**
	 * 微信成功返回
	 */
	Integer WX_SUCCESS = 1001;

	Byte BYTE_YES = 1;
	Byte BYTE_NO = 0;

	/**
	 * 默认存储bucket
	 */
	String BUCKET_NAME = "rongdih";
	/**
	 */
    CharSequence DEFAULT_PASSWORD = "123456";
	/**
	 * http://192.168.1.94:9000
	 */
	String DEFAULT_MINIO_NODE = "ih";

	/**
	 * 用户短信验证码
	 */
	String WX_PHONE_CODE_KEY = "PHONE_CODE_KEY";

	String ZGX_API_TOKEN = "ZGX_API_TOKEN";

	/**
	 * 正广兴token有效期
	 */
	int ZGX_API_TOKEN_TIME = 3600;

	/**
	 * 验证码有效期
	 */
	int CODE_TIME = 60;
	/**
	 * 身份证件最大位数
	 */
	int ID_CARD_LENGTH = 18;
}
