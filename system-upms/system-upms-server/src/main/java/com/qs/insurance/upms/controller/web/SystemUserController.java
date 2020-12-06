package com.qs.insurance.upms.controller.web;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qs.insurance.system.common.core.constant.RenRenConstant;
import com.qs.insurance.system.common.core.utils.R;
import com.qs.insurance.system.common.log.annotation.SysLog;
import com.qs.insurance.upms.entity.SystemUser;
import com.qs.insurance.upms.service.SystemUserService;
import com.qs.insurance.upms.utils.AppSecurityUtils;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 系统用户
 *
 * @author wb
 * @date 2020-12-03 23:16:39
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/sys/user")
@Api(value = "系统用户", tags = "系统用户")
public class SystemUserController {

  private final  SystemUserService systemUserService;
  /**
   * 所有用户列表
   */
  @GetMapping("/list")
  public R list(@RequestParam Map<String, Object> params){
    //只有超级管理员，才能查看所有管理员列表
    LambdaQueryWrapper<SystemUser> lambda = Wrappers.<SystemUser>query().lambda();
    if(AppSecurityUtils.getUserId() != RenRenConstant.SUPER_ADMIN){
      params.put("createUserId", AppSecurityUtils.getUserId());
      lambda.eq(SystemUser::getId,params.get("createUserId"));
    }
    Page<SystemUser> systemUserPage = new Page<>(Long.parseLong(params.get("page").toString()) , Long.parseLong(params.get("limit").toString()) );
    if (StringUtils.isNotBlank(params.get("username").toString())){
      lambda.like(SystemUser::getName,StringUtils.isNotBlank(params.get("username").toString()));
    }
    return new R<>(systemUserService.page(systemUserPage));
  }

  /**
   * 获取登录的用户信息
   */
  @GetMapping("/info")
  public R info(){
    return new R<>(AppSecurityUtils.getUser());
  }

  /**
   * 修改登录用户密码
   */
//  @SysLog("修改密码")
//  @PostMapping("/password")
//  public R password(@RequestBody PasswordForm form){
////    Assert.isBlank(form.getNewPassword(), "新密码不为能空");
//
//    //sha256加密
//    String password = new Sha256Hash(form.getPassword(), getUser().getSalt()).toHex();
//    //sha256加密
//    String newPassword = new Sha256Hash(form.getNewPassword(), getUser().getSalt()).toHex();
//
//    //更新密码
//    boolean flag = sysUserService.updatePassword(getUserId(), password, newPassword);
//    if(!flag){
//      return R.error("原密码不正确");
//    }
//
//    return R.ok();
//  }

  /**
   * 用户信息
   */
  @GetMapping("/info/{userId}")
  public R info(@PathVariable("userId") Long userId){
    SystemUser user = systemUserService.getById(userId);

    //获取用户所属的角色列表
//    List<Long> roleIdList = systemUserService.queryRoleIdList(userId);
//    user.setRoleIdList(roleIdList);

    return new R<>(user);
  }

  /**
   * 保存用户
   */
  @SysLog("保存用户")
  @PostMapping("/save")
  @RequiresPermissions("sys:user:save")
  public R save(@RequestBody SystemUser user){

//    user.setCreateUserId(getUserId());
//    systemUserService.saveUser(user);

    return new R();
  }

  /**
   * 修改用户
   */
//  @SysLog("修改用户")
//  @PostMapping("/update")
//  @RequiresPermissions("sys:user:update")
//  public R update(@RequestBody SysUserEntity user){
//    ValidatorUtils.validateEntity(user, UpdateGroup.class);
//
//    user.setCreateUserId(getUserId());
//    sysUserService.update(user);
//
//    return R.ok();
//  }
//
//  /**
//   * 删除用户
//   */
//  @SysLog("删除用户")
//  @PostMapping("/delete")
//  @RequiresPermissions("sys:user:delete")
//  public R delete(@RequestBody Long[] userIds){
//    if(ArrayUtils.contains(userIds, 1L)){
//      return R.error("系统管理员不能删除");
//    }
//
//    if(ArrayUtils.contains(userIds, getUserId())){
//      return R.error("当前用户不能删除");
//    }
//
//    sysUserService.deleteBatch(userIds);
//
//    return R.ok();
//  }
}
