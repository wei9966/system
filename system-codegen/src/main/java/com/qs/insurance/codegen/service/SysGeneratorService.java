
package com.qs.insurance.codegen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qs.insurance.codegen.model.GenConfig;

import java.util.List;
import java.util.Map;

/**
 *
 * @Author jhy
 * @Date  2020/6/17 10:17 下午
 * @Description :
 *
 */
public interface SysGeneratorService {
	/**
	 * 生成代码
	 *
	 * @param tableNames 表名称
	 * @return
	 */
	byte[] generatorCode(GenConfig tableNames) throws Exception;

	/**
	 * 分页查询表
	 * @param tableName 表名
	 * @return
	 */
	IPage<List<Map<String, Object>>> getPage(Page page, String tableName);
}
