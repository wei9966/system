package com.qs.insurance.upms.controller.web;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qs.insurance.system.common.core.utils.R;
import com.qs.insurance.upms.entity.SystemUser;
import com.qs.insurance.upms.service.SystemUserService;
import lombok.AllArgsConstructor;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;


/**
 * 系统用户
 *
 * @author wb
 * @date 2020-12-03 23:16:39
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/systemuser")
@Api(value = "系统用户", tags = "系统用户")
public class SystemUserController {

  private final  SystemUserService systemUserService;

  /**
   * 分页查询
   * @param page 分页对象
   * @param systemUser 系统用户
   * @return
   */
  @ApiOperation("分页查询系统用户")
  @GetMapping("/page")
  public R getSystemUserPage(Page page, SystemUser systemUser) {
    return  new R<>(systemUserService.page(page,Wrappers.query(systemUser)));
  }


  /**
   * 通过id查询系统用户
   * @param id id
   * @return R
   */
  @ApiOperation("通过id查询系统用户")
  @GetMapping("/{id}")
  public R getById(@PathVariable("id") Long id){
    return new R<>(systemUserService.getById(id));
  }

  /**
   * 新增系统用户
   * @param systemUser 系统用户
   * @return R
   */
  @ApiOperation("新增系统用户")
  @PostMapping
  public R save(@RequestBody SystemUser systemUser){
    return new R<>(systemUserService.save(systemUser));
  }

  /**
   * 修改系统用户
   * @param systemUser 系统用户
   * @return R
   */
  @ApiOperation("修改系统用户")
  @PutMapping
  public R updateById(@RequestBody SystemUser systemUser){
    return new R<>(systemUserService.updateById(systemUser));
  }

  /**
   * 通过id删除系统用户
   * @param id id
   * @return R
   */
  @ApiOperation("删除系统用户")
  @DeleteMapping("/{id}")
  public R removeById(@PathVariable Long id){
    return new R<>(systemUserService.removeById(id));
  }

}
