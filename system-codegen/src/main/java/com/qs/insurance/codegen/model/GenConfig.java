package com.qs.insurance.codegen.model;

import lombok.Data;

/**
 *
 * @Date  2020/6/17 10:15 下午
 * @Description :生成配置
 *
 */
@Data
public class GenConfig {
	/**
	 * 包名
	 */
	private String packageName;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 模块名称
	 */
	private String moduleName;
	/**
	 * 表前缀
	 */
	private String tablePrefix;

	/**
	 * 表名称
	 */
	private String tableName;
	/**
	 * 库名称
	 */
	private String storehouseName;

	/**
	 * 表备注
	 */
	private String comments;
}
