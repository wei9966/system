
package com.qs.insurance.codegen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qs.insurance.codegen.model.GenConfig;
import com.qs.insurance.codegen.model.SysGenerator;

import java.util.Map;

/**
 *
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
	 * @return
	 */
	IPage<SysGenerator> getPage(Map map);
}
