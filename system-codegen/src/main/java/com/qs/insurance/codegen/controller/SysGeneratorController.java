package com.qs.insurance.codegen.controller;

import cn.hutool.core.io.IoUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qs.insurance.codegen.model.GenConfig;
import com.qs.insurance.codegen.service.SysGeneratorService;
import com.qs.insurance.system.common.core.utils.R;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 *
 * @Author jhy
 * @Date  2020/6/17 10:14 下午
 * @Description :代码生成器
 *
 */
@RestController
@AllArgsConstructor
@RequestMapping("/generator")
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
	public R getPage(Page page, String tableName) {
		return new R<>(sysGeneratorService.getPage(page, tableName));
	}

	/**
	 * 生成代码
	 * jhy
	 */
	@SneakyThrows
	@PostMapping("/code")
	public void generatorCode(@RequestBody GenConfig genConfig, HttpServletResponse response) {
		byte[] data = sysGeneratorService.generatorCode(genConfig);

		response.reset();
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s.zip", genConfig.getTableName()));
		response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(data.length));
		response.setContentType("application/octet-stream; charset=UTF-8");

		IoUtil.write(response.getOutputStream(), Boolean.TRUE, data);
	}
}
