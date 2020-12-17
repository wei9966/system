package com.qs.insurance.message.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qs.insurance.message.entity.ShortMessage;
import com.qs.insurance.message.service.ShortMessageService;
import com.qs.insurance.system.common.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


/**
 * 聚码主表
 *
 * @author asd
 * @date 2020-12-18 00:54:52
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/shortmessage")
@Api(value = "聚码主表", tags = "聚码主表")
public class Shortontroller {

  private final ShortMessageService shortMessageService;

  /**
   * 分页查询
   * @param page 分页对象
   * @param shortMessage 聚码主表
   * @return
   */
  @ApiOperation("分页查询聚码主表")
  @GetMapping("/page")
  public R getShortMessagePage(Page page, ShortMessage shortMessage) {
    return  new R<>(shortMessageService.page(page,Wrappers.query(shortMessage)));
  }


  /**
   * 通过id查询聚码主表
   * @param id id
   * @return R
   */
  @ApiOperation("通过id查询聚码主表")
  @GetMapping("/{id}")
  public R getById(@PathVariable("id") Long id){
    return new R<>(shortMessageService.getById(id));
  }

  /**
   * 新增聚码主表
   * @param shortMessage 聚码主表
   * @return R
   */
  @ApiOperation("新增聚码主表")
  @PostMapping
  public R save(@RequestBody ShortMessage shortMessage){
    return new R<>(shortMessageService.save(shortMessage));
  }

  /**
   * 修改聚码主表
   * @param shortMessage 聚码主表
   * @return R
   */
  @ApiOperation("修改聚码主表")
  @PutMapping
  public R updateById(@RequestBody ShortMessage shortMessage){
    return new R<>(shortMessageService.updateById(shortMessage));
  }

  /**
   * 通过id删除聚码主表
   * @param id id
   * @return R
   */
  @ApiOperation("删除聚码主表")
  @PostMapping("/delete")
  public R removeById(@PathVariable Long id){
    return new R<>(shortMessageService.removeById(id));
  }

}
