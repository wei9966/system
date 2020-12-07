/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.qs.insurance.upms.controller.web;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qs.insurance.system.common.core.constant.RenRenConstant;
import com.qs.insurance.system.common.core.utils.R;
import com.qs.insurance.system.common.log.annotation.SysLog;
import com.qs.insurance.system.common.security.utils.AppSecurityUtils;
import com.qs.insurance.upms.entity.SysRole;
import com.qs.insurance.upms.service.SysRoleMenuService;
import com.qs.insurance.upms.service.SysRoleService;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色管理
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/sys/role")
@Api(tags = "角色管理")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysRoleMenuService sysRoleMenuService;

	/**
	 * 角色列表
	 */
	@GetMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
//		//如果不是超级管理员，则只查询自己创建的角色列表
		LambdaQueryWrapper<SysRole> lambda = Wrappers.<SysRole>query().lambda();
		if(AppSecurityUtils.getUserId() != RenRenConstant.SUPER_ADMIN){
			params.put("createUserId", AppSecurityUtils.getUserId());
			lambda.eq(SysRole::getCreateUserId,params.get("createUserId"));
		}
		Page<SysRole> sysRolePage = new Page<>(Long.parseLong(params.get("page").toString()),Long.parseLong(params.get("limit").toString()));
		if (StringUtils.isNotBlank(params.get("roleName").toString())){
			lambda.like(SysRole::getRoleName,params.get("roleName"));
		}
		return new R<>(sysRoleService.page(sysRolePage,lambda));
	}
	
	/**
	 * 角色列表
	 */
	@GetMapping("/select")
	public R select(){
		Map<String, Object> map = new HashMap<>();
		
		//如果不是超级管理员，则只查询自己所拥有的角色列表
		if(AppSecurityUtils.getUserId() != RenRenConstant.SUPER_ADMIN){
			map.put("createUserId", AppSecurityUtils.getUserId());
		}
		List<SysRole> list = (List<SysRole>) sysRoleService.listByMap(map);
		
		return new R<>(list);
	}
	
	/**
	 * 角色信息
	 */
	@GetMapping("/info/{roleId}")
	public R info(@PathVariable("roleId") Long roleId){
		SysRole role = sysRoleService.getById(roleId);
		//查询角色对应的菜单
		List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(roleId);
		role.setMenuIdList(menuIdList);
		return new R<>(role);
	}
	
	/**
	 * 保存角色
	 */
	@SysLog("保存角色")
	@PostMapping("/save")
	public R save(@RequestBody SysRole role){
//		ValidatorUtils.validateEntity(role);
		role.setCreateUserId(AppSecurityUtils.getUserId());
		sysRoleService.saveRole(role);
			return new R();
	}
	
	/**
	 * 修改角色
	 */
	@SysLog("修改角色")
	@PostMapping("/update")
	public R update(@RequestBody SysRole role){
//		ValidatorUtils.validateEntity(role);
		role.setCreateUserId(AppSecurityUtils.getUserId());
		sysRoleService.update(role);
		
		return new R();
	}
	
	/**
	 * 删除角色
	 */
	@SysLog("删除角色")
	@PostMapping("/delete")
	public R delete(@RequestBody Long[] roleIds){
		sysRoleService.deleteBatch(roleIds);
		
		return new R();
	}
}
