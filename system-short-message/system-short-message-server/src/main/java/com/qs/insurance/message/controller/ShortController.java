package com.qs.insurance.message.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qs.insurance.message.entity.ShortMessage;
import com.qs.insurance.message.service.ShortMessageService;
import com.qs.insurance.system.common.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 聚码主表
 *
 * @author wb
 * @date 2020-12-18 10:03:12
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/shortmessage")
@Api(value = "聚码主表", tags = "聚码主表")
public class ShortController {

  private final  ShortMessageService shortMessageService;

  /**
   * 分页查询聚码主表
   * @param pageNo 分页数量
   * @return
   */
  @ApiOperation("分页查询聚码主表")
  @GetMapping("/list")
  public R getShortMessagePage(@ApiParam("当前页数") @RequestParam("pageNo") Integer pageNo,
                               @ApiParam("每页显示条数")@RequestParam("pageSize")Integer pageSize) {
    Page<ShortMessage> shortMessagePage = new Page<>(pageNo, pageSize);
    LambdaQueryWrapper<ShortMessage> shortMessageWrapper = Wrappers.<ShortMessage>query().lambda();
    return  new R<>(shortMessageService.page(shortMessagePage,shortMessageWrapper));
  }


  /**
   * 通过id查询聚码主表
   * @param id id
   * @return R
   */
  @ApiOperation("通过id查询聚码主表")
  @GetMapping("/info/{id}")
  public R getById(@PathVariable("id") Long id){
    return new R<>(shortMessageService.getById(id));
  }

  /**
   * 新增聚码主表
   * @param shortMessage 聚码主表
   * @return R
   */
  @ApiOperation("新增聚码主表")
  @PostMapping("/save")
  public R save(@RequestBody ShortMessage shortMessage){
    return new R<>(shortMessageService.save(shortMessage));
  }

  /**
   * 修改聚码主表
   * @param shortMessage 聚码主表
   * @return R
   */
  @ApiOperation("修改聚码主表")
  @PostMapping("/update")
  public R updateById(@RequestBody ShortMessage shortMessage){
    return new R<>(shortMessageService.updateById(shortMessage));
  }

  /**
   * 通过ids删除聚码主表
   * @return R
   */
  @PostMapping("/delete")
  public R delete(@RequestBody Long[] ids){
    return new R<>(shortMessageService.removeByIds(Arrays.asList(ids)));
  }

}
