package com.qs.insurance.message.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qs.insurance.message.entity.ShortMessageLoginRecord;
import com.qs.insurance.message.service.ShortMessageLoginRecordService;
import com.qs.insurance.system.common.core.utils.R;
import com.qs.insurance.system.common.log.annotation.SysLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


/**
 * 短信登录记录
 *
 * @author wb
 * @date 2020-12-03 20:04:18
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/short/message/login/record")
@Api(value = "短信登录记录", tags = "短信登录记录")
public class ShortMessageLoginRecordController {

  private final  ShortMessageLoginRecordService shortMessageLoginRecordService;

  /**
   * 分页查询
   * @param page 分页对象
   * @param shortMessageLoginRecord 短信登录记录
   * @return
   */
  @ApiOperation("分页查询短信登录记录")
  @GetMapping("/page")
  public R getShortMessageLoginRecordPage(Page page, ShortMessageLoginRecord shortMessageLoginRecord) {
    return  new R<>(shortMessageLoginRecordService.page(page,Wrappers.query(shortMessageLoginRecord)));
  }


  /**
   * 通过id查询短信登录记录
   * @param id id
   * @return R
   */
  @ApiOperation("通过id查询短信登录记录")
  @GetMapping("/{id}")
  public R getById(@PathVariable("id") Long id){
    return new R<>(shortMessageLoginRecordService.getById(id));
  }

  /**
   * 新增短信登录记录
   * @param shortMessageLoginRecord 短信登录记录
   * @return R
   */
  @ApiOperation("新增短信登录记录")
  @SysLog("新增短信登录记录")
  @PostMapping
  public R save(@RequestBody ShortMessageLoginRecord shortMessageLoginRecord){
    return new R<>(shortMessageLoginRecordService.save(shortMessageLoginRecord));
  }

  /**
   * 修改短信登录记录
   * @param shortMessageLoginRecord 短信登录记录
   * @return R
   */
  @ApiOperation("修改短信登录记录")
  @SysLog("修改短信登录记录")
  @PutMapping
  public R updateById(@RequestBody ShortMessageLoginRecord shortMessageLoginRecord){
    return new R<>(shortMessageLoginRecordService.updateById(shortMessageLoginRecord));
  }

  /**
   * 通过id删除短信登录记录
   * @param id id
   * @return R
   */
  @ApiOperation("删除短信登录记录")
  @SysLog("删除短信登录记录")
  @DeleteMapping("/{id}")
  public R removeById(@PathVariable Long id){
    return new R<>(shortMessageLoginRecordService.removeById(id));
  }

}
