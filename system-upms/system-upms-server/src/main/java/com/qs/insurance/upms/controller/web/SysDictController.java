package com.qs.insurance.upms.controller.web;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.qs.insurance.system.common.core.utils.R;
import com.qs.insurance.upms.entity.SysDict;
import com.qs.insurance.upms.service.SysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 数据字典
 *
 * @author wb
 * @date 2020-12-28 10:58:10
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/sysdict")
@Api(value = "数据字典", tags = "数据字典")
public class SysDictController {

  private final  SysDictService sysDictService;

  /**
   * 分页查询数据字典
   * @param
   * @return
   */
  @ApiOperation("查询数据字典")
  @GetMapping("/list")
  public R getSysDictPage(@RequestParam(value = "key",required = false) String key) {
    LambdaQueryWrapper<SysDict> lambda = Wrappers.<SysDict>query().lambda();
    if (StringUtils.isNotBlank(key)){
      lambda.like(SysDict::getDescription,key);
    }
    return  new R<>(sysDictService.list(lambda));
  }


  /**
   * 通过id查询数据字典
   * @param dictId id
   * @return R
   */
  @ApiOperation("通过id查询数据字典")
  @GetMapping("/info/{dictId}")
  public R getById(@PathVariable("dictId") Long dictId){
    return new R<>(sysDictService.getById(dictId));
  }

  /**
   * 新增数据字典
   * @param sysDict 数据字典
   * @return R
   */
  @ApiOperation("新增数据字典")
  @PostMapping("/save")
  public R save(@RequestBody SysDict sysDict){
    return new R<>(sysDictService.save(sysDict));
  }

  /**
   * 修改数据字典
   * @param sysDict 数据字典
   * @return R
   */
  @ApiOperation("修改数据字典")
  @PostMapping("/update")
  public R updateById(@RequestBody SysDict sysDict){
    return new R<>(sysDictService.updateById(sysDict));
  }

  /**
   * 通过ids删除数据字典
   * @return R
   */
  @PostMapping("/delete")
  public R delete(@RequestBody Long[] dictIds){
    return new R<>(sysDictService.removeByIds(Arrays.asList(dictIds)));
  }

}
