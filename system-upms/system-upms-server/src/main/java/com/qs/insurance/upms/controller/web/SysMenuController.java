/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.qs.insurance.upms.controller.web;

import com.qs.insurance.system.common.core.constant.RenRenConstant;
import com.qs.insurance.system.common.core.utils.MapUtils;
import com.qs.insurance.system.common.core.utils.R;
import com.qs.insurance.system.common.log.annotation.SysLog;
import com.qs.insurance.upms.entity.SysMenu;
import com.qs.insurance.upms.entity.SystemUser;
import com.qs.insurance.upms.service.ShiroService;
import com.qs.insurance.upms.service.SysMenuService;
import com.qs.insurance.upms.utils.AppSecurityUtils;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * 系统菜单
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/sys/menu")
@AllArgsConstructor
@Slf4j
@Api(tags = "系統菜单管理")
public class SysMenuController {
	private final SysMenuService sysMenuService;
	private final ShiroService shiroService;

	/**
	 * 导航菜单
	 */
	@GetMapping("/nav")
	public R nav(){

		log.info("当前登录的人"+ AppSecurityUtils.getUser());
		SystemUser principal = AppSecurityUtils.getUser();
		List<SysMenu> menuList = sysMenuService.getUserMenuList(principal.getId());
		Set<String> permissions = shiroService.getUserPermissions(principal.getId());
		return new R<>(new MapUtils().put("menuList",menuList).put("permissions",permissions));
	}
	
	/**
	 * 所有菜单列表
	 */
	@GetMapping("/list")
	public List<SysMenu> list(){
		List<SysMenu> menuList = sysMenuService.list();
		for(SysMenu sysMenuEntity : menuList){
			SysMenu parentMenuEntity = sysMenuService.getById(sysMenuEntity.getParentId());
			if(parentMenuEntity != null){
				sysMenuEntity.setParentName(parentMenuEntity.getName());
			}
		}
		return menuList;
	}
	
	/**
	 * 选择菜单(添加、修改菜单)
	 */
	@GetMapping("/select")
	public R select(){
		//查询列表数据
		List<SysMenu> menuList = sysMenuService.queryNotButtonList();
		
		//添加顶级菜单
		SysMenu root = new SysMenu();
		root.setMenuId(0L);
		root.setName("一级菜单");
		root.setParentId(-1L);
		root.setOpen(true);
		menuList.add(root);
		
//		return R.ok().put("menuList", menuList);
		return new R<>(menuList);
	}
	
	/**
	 * 菜单信息
	 */
	@GetMapping("/info/{menuId}")
	public R info(@PathVariable("menuId") Long menuId){
		SysMenu menu = sysMenuService.getById(menuId);
		return new R<>(menu);
	}
	
	/**
	 * 保存
	 */
	@SysLog("保存菜单")
	@PostMapping("/save")
	public R save(@RequestBody SysMenu menu){
		//数据校验
		verifyForm(menu);
		
		sysMenuService.save(menu);

		return new R();
	}
	
	/**
	 * 修改
	 */
	@SysLog("修改菜单")
	@PostMapping("/update")
	public R update(@RequestBody SysMenu menu){
		//数据校验
		verifyForm(menu);
				
		sysMenuService.updateById(menu);
		return new R();
	}
	
	/**
	 * 删除
	 */
	@SysLog("删除菜单")
	@PostMapping("/delete/{menuId}")
	public R delete(@PathVariable("menuId") long menuId){
		if(menuId <= 31){
			return new R().error("系统菜单，不能删除");
		}

		//判断是否有子菜单或按钮
		List<SysMenu> menuList = sysMenuService.queryListParentId(menuId);
		if(menuList.size() > 0){
			return new R().error("请先删除子菜单或按钮");
		}

		sysMenuService.delete(menuId);

		return new R();
	}
	
	/**
	 * 验证参数是否正确
	 */
	private void verifyForm(SysMenu menu){
		if(StringUtils.isBlank(menu.getName())){
			throw new RuntimeException("菜单名称不能为空");
		}
		
		if(menu.getParentId() == null){
			throw new RuntimeException("上级菜单不能为空");
		}
		
		//菜单
		if(menu.getType() == RenRenConstant.MenuType.MENU.getValue()){
			if(StringUtils.isBlank(menu.getUrl())){
				throw new RuntimeException("菜单URL不能为空");
			}
		}
		
		//上级菜单类型
		int parentType = RenRenConstant.MenuType.CATALOG.getValue();
		if(menu.getParentId() != 0){
			SysMenu parentMenu = sysMenuService.getById(menu.getParentId());
			parentType = parentMenu.getType();
		}
		
		//目录、菜单
		if(menu.getType() == RenRenConstant.MenuType.CATALOG.getValue() ||
				menu.getType() == RenRenConstant.MenuType.MENU.getValue()){
			if(parentType != RenRenConstant.MenuType.CATALOG.getValue()){
				throw new RuntimeException("上级菜单只能为目录类型");
			}
			return ;
		}
		
		//按钮
		if(menu.getType() == RenRenConstant.MenuType.BUTTON.getValue()){
			if(parentType != RenRenConstant.MenuType.MENU.getValue()){
				throw new RuntimeException("上级菜单只能为菜单类型");
			}
			return ;
		}
	}
}
