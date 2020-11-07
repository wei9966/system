package com.qs.insurance.codegen.service.impl;

import cn.hutool.core.io.IoUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qs.insurance.codegen.dao.SysGeneratorMapper;
import com.qs.insurance.codegen.model.GenConfig;
import com.qs.insurance.codegen.service.SysGeneratorService;
import com.qs.insurance.codegen.util.GenUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 *
 * @Author jhy
 * @Date  2020/6/17 10:16 下午
 * @Description :代码生成器
 *
 */
@Service
@AllArgsConstructor
public class SysGeneratorServiceImpl implements SysGeneratorService {
	private final SysGeneratorMapper sysGeneratorMapper;


	/**
	 * 分页查询表
	 *
	 * @param tableName 查询条件
	 * @return
	 */
	@Override
	public IPage<List<Map<String, Object>>> getPage(Page page, String tableName) {
		return sysGeneratorMapper.queryList(page,tableName);
	}

	/**
	 * 生成代码
	 *
	 * @param genConfig jhy 生成配置
	 * @return
	 */
	@Override
	public byte[] generatorCode(GenConfig genConfig) throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);
		Map<String,String> map = new HashMap<>();
		map.put("tableName",genConfig.getTableName());
		map.put("storehouseName",genConfig.getStorehouseName());
		//查询表信息
		Map<String, String> table = queryTable(map);
		//查询列信息
		List<Map<String, String>> columns = queryColumns(map);
		//生成代码
		GenUtils.generatorCode(genConfig, table, columns, zip);
		IoUtil.close(zip);
		return outputStream.toByteArray();
	}

	private Map<String, String> queryTable( Map<String, String> map) {
		return sysGeneratorMapper.queryTable(map);
	}

	private List<Map<String, String>> queryColumns(Map<String, String> map) {
		return sysGeneratorMapper.queryColumns(map);
	}
}
