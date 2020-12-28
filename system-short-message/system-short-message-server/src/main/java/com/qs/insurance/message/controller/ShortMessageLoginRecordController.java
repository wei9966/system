package com.qs.insurance.message.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qs.insurance.message.entity.ShortMessageLoginRecord;
import com.qs.insurance.message.service.ShortMessageLoginRecordService;
import com.qs.insurance.system.common.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 聚码登录记录
 *
 * @author wb
 * @date 2020-12-18 10:59:29
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/shortmessageloginrecord")
@Api(value = "聚码登录记录", tags = "聚码登录记录")
public class ShortMessageLoginRecordController {

  private final  ShortMessageLoginRecordService shortMessageLoginRecordService;

  /**
   * 分页查询聚码登录记录
   * @param pageNo 分页数量
   * @return
   */
  @ApiOperation("分页查询聚码登录记录")
  @GetMapping("/list")
  public R getShortMessageLoginRecordPage(@ApiParam("当前页数") @RequestParam("pageNo") Integer pageNo,
                               @ApiParam("每页显示条数")@RequestParam("pageSize")Integer pageSize) {
    Page<ShortMessageLoginRecord> shortMessageLoginRecordPage = new Page<>(pageNo, pageSize);
    LambdaQueryWrapper<ShortMessageLoginRecord> shortMessageLoginRecordWrapper = Wrappers.<ShortMessageLoginRecord>query().lambda();
    return  new R<>(shortMessageLoginRecordService.page(shortMessageLoginRecordPage,shortMessageLoginRecordWrapper));
  }


  /**
   * 通过id查询聚码登录记录
   * @param id id
   * @return R
   */
  @ApiOperation("通过id查询聚码登录记录")
  @GetMapping("/info/{id}")
  public R getById(@PathVariable("id") Long id){
    return new R<>(shortMessageLoginRecordService.getById(id));
  }

  /**
   * 新增聚码登录记录
   * @param shortMessageLoginRecord 聚码登录记录
   * @return R
   */
  @ApiOperation("新增聚码登录记录")
  @PostMapping("/save")
  public R save(@RequestBody ShortMessageLoginRecord shortMessageLoginRecord){
    return new R<>(shortMessageLoginRecordService.save(shortMessageLoginRecord));
  }

  /**
   * 修改聚码登录记录
   * @param shortMessageLoginRecord 聚码登录记录
   * @return R
   */
  @ApiOperation("修改聚码登录记录")
  @PostMapping("/update")
  public R updateById(@RequestBody ShortMessageLoginRecord shortMessageLoginRecord){
    return new R<>(shortMessageLoginRecordService.updateById(shortMessageLoginRecord));
  }

  /**
   * 通过ids删除聚码登录记录
   * @return R
   */
  @PostMapping("/delete")
  public R delete(@RequestBody Long[] ids){
    return new R<>(shortMessageLoginRecordService.removeByIds(Arrays.asList(ids)));
  }

}
