package com.qs.insurance.codegen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qs.insurance.codegen.model.SysGenerator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author jhy
 * @Date 2020/6/17 10:15 下午
 * @Description :代码生成器
 */
@Mapper
public interface SysGeneratorMapper extends BaseMapper<SysGenerator> {

	/**
	 * 分页查询表格
	 *
	 * @return
	 */
	List<SysGenerator> queryList(Map<String, Object> map);


	/**
	 * 查询表列信息
	 *
	 * @return
	 */
	List<Map<String, String>> queryColumns(@Param("query") Map<String, String> map);

	Map<String, String> queryTable(@Param("query") Map<String, String> map);
}
