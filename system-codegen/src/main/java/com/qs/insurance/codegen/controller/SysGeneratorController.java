package com.qs.insurance.codegen.controller;

import cn.hutool.core.io.IoUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qs.insurance.codegen.model.GenConfig;
import com.qs.insurance.codegen.service.SysGeneratorService;
import com.qs.insurance.system.common.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 *
 * @Author wb
 * @Date  2020/11/8
 * @Description :代码生成器
 *
 */
@RestController
@AllArgsConstructor
@RequestMapping("/generator")
@Api(value = "代碼生成器",tags = "代码生成器")
public class SysGeneratorController {
	private final SysGeneratorService sysGeneratorService;

	/**
	 * 列表
	 * jhy
	 *
	 * @param tableName 参数集
	 * @return 数据库表
	 */
	@GetMapping("/page")
	@ApiOperation("获取可生成列表")
	public R getPage(@ApiParam("分页参数") Page page, @ApiParam("表名") String tableName) {
		return new R<>(sysGeneratorService.getPage(page, tableName));
	}

	/**
	 * 生成代码
	 * jhy
	 */
	@SneakyThrows
	@PostMapping("/code")
	@ApiOperation("代码生成")
	public void generatorCode(@ApiParam("生成参数")@RequestBody GenConfig genConfig, HttpServletResponse response) {
		byte[] data = sysGeneratorService.generatorCode(genConfig);
		response.reset();
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s.zip", genConfig.getTableName()));
		response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(data.length));
		response.setContentType("application/octet-stream; charset=UTF-8");
		IoUtil.write(response.getOutputStream(), Boolean.TRUE, data);
	}
}
