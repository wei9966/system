

package com.qs.insurance.codegen.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 * @Author jhy
 * @Date  2020/6/17 10:15 下午
 * @Description :代码生成器
 *
 */
@Mapper
public interface SysGeneratorMapper {

	/**
	 * 分页查询表格
	 *
	 * @param page
	 * @param tableName
	 * @return
	 */
	IPage<List<Map<String, Object>>> queryList(Page page, @Param("tableName") String tableName);


	/**
	 * 查询表列信息
	 *
	 * @return
	 */
	List<Map<String, String>> queryColumns(@Param("query") Map<String, String> map);

	Map<String, String> queryTable(@Param("query") Map<String, String> map);
}
