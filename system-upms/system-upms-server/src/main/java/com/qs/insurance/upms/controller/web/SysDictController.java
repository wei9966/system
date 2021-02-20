package com.qs.insurance.upms.controller.web;

import com.qs.insurance.system.common.core.utils.R;
import com.qs.insurance.upms.entity.SysDict;
import com.qs.insurance.upms.repository.SysDictRepository;
import com.qs.insurance.upms.service.SysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

  private final SysDictRepository sysDictRepository;

  /**
   * 分页查询数据字典
   * @param
   * @return
   */
  @ApiOperation("查询数据字典")
  @GetMapping("/list")
  public R getSysDictPage(@RequestParam(value = "key",required = false) String key) {
    ArrayList<SysDict> sysDicts = new ArrayList<>();
    sysDictRepository.findAll().forEach(sysDicts::add);
    return  new R<>(sysDicts);
  }

  @ApiOperation("同步es数据")
  @GetMapping("synchronize")
  public R sysDcitSynchronize(){
    List<SysDict> list = this.sysDictService.list();
    return new R<>(sysDictRepository.saveAll(list));
  }


  /**
   * 通过id查询数据字典
   * @param dictId id
   * @return R
   */
  @ApiOperation("通过id查询数据字典")
  @GetMapping("/info/{dictId}")
  public R getById(@PathVariable("dictId") Long dictId){
//    return new R<>(sysDictService.getById(dictId));
    return new R<>(sysDictRepository.findById(dictId));
  }

  /**
   * 新增数据字典
   * @param sysDict 数据字典
   * @return R
   */
  @ApiOperation("新增数据字典")
  @PostMapping("/save")
  public R save(@RequestBody SysDict sysDict){
    sysDictService.save(sysDict);
    sysDictRepository.save(sysDict);
    return new R<>();
  }

  /**
   * 修改数据字典
   * @param sysDict 数据字典
   * @return R
   */
  @ApiOperation("修改数据字典")
  @PostMapping("/update")
  public R updateById(@RequestBody SysDict sysDict){
    sysDictService.updateById(sysDict);
    sysDictRepository.findById(sysDict.getDictId()).ifPresent(sysDict1 -> {
      sysDictRepository.save(sysDict);
    });
    return new R<>(true);
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
