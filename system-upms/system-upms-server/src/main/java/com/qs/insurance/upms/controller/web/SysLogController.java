package com.qs.insurance.upms.controller.web;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qs.insurance.system.common.core.utils.R;
import com.qs.insurance.upms.entity.SysLog;
import com.qs.insurance.upms.service.SysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 日志表
 *
 * @author wb
 * @date 2020-12-28 14:47:03
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/syslog")
@Api(value = "日志表", tags = "日志表")
public class SysLogController {

  private final  SysLogService sysLogService;

  /**
   * 分页查询日志表
   * @param pageNo 分页数量
   * @return
   */
  @ApiOperation("分页查询日志表")
  @GetMapping("/list")
  public R getSysLogPage(@ApiParam("当前页数") @RequestParam("pageNo") Integer pageNo,
                               @ApiParam("每页显示条数")@RequestParam("pageSize")Integer pageSize) {
    Page<SysLog> sysLogPage = new Page<>(pageNo, pageSize);
    LambdaQueryWrapper<SysLog> sysLogWrapper = Wrappers.<SysLog>query().lambda();
    return  new R<>(sysLogService.page(sysLogPage,sysLogWrapper));
  }


  /**
   * 通过id查询日志表
   * @param id id
   * @return R
   */
  @ApiOperation("通过id查询日志表")
  @GetMapping("/info/{id}")
  public R getById(@PathVariable("id") Long id){
    return new R<>(sysLogService.getById(id));
  }

  /**
   * 新增日志表
   * @param sysLog 日志表
   * @return R
   */
  @ApiOperation("新增日志表")
  @PostMapping("/save")
  public R save(@RequestBody SysLog sysLog){
    return new R<>(sysLogService.save(sysLog));
  }

  /**
   * 修改日志表
   * @param sysLog 日志表
   * @return R
   */
  @ApiOperation("修改日志表")
  @PostMapping("/update")
  public R updateById(@RequestBody SysLog sysLog){
    return new R<>(sysLogService.updateById(sysLog));
  }

  /**
   * 通过ids删除日志表
   * @return R
   */
  @PostMapping("/delete")
  public R delete(@RequestBody Long[] ids){
    return new R<>(sysLogService.removeByIds(Arrays.asList(ids)));
  }

}
