package com.qs.insurance.upms.controller.web;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qs.insurance.system.common.core.utils.R;
import com.qs.insurance.upms.entity.SysDictDetail;
import com.qs.insurance.upms.service.SysDictDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 数据字典详情
 *
 * @author wb
 * @date 2020-12-28 11:03:20
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/sysdictdetail")
@Api(value = "数据字典详情", tags = "数据字典详情")
public class SysDictDetailController {

  private final  SysDictDetailService sysDictDetailService;

  /**
   * 分页查询数据字典详情
   * @param pageNo 分页数量
   * @return
   */
  @ApiOperation("分页查询数据字典详情")
  @GetMapping("/list")
  public R getSysDictDetailPage(@ApiParam("当前页数") @RequestParam("pageNo") Integer pageNo,
                               @ApiParam("每页显示条数")@RequestParam("pageSize")Integer pageSize,
                                @ApiParam("dictId")@RequestParam("dictId")Long dictId) {
    Page<SysDictDetail> sysDictDetailPage = new Page<>(pageNo, pageSize);
    LambdaQueryWrapper<SysDictDetail> sysDictDetailWrapper = Wrappers.<SysDictDetail>query().lambda();
    sysDictDetailWrapper.eq(SysDictDetail::getDictId,dictId);
    return  new R<>(sysDictDetailService.page(sysDictDetailPage,sysDictDetailWrapper));
  }


  /**
   * 通过id查询数据字典详情
   * @param detailId id
   * @return R
   */
  @ApiOperation("通过id查询数据字典详情")
  @GetMapping("/info/{detailId}")
  public R getById(@PathVariable("detailId") Long detailId){
    return new R<>(sysDictDetailService.getById(detailId));
  }

  /**
   * 新增数据字典详情
   * @param sysDictDetail 数据字典详情
   * @return R
   */
  @ApiOperation("新增数据字典详情")
  @PostMapping("/save")
  public R save(@RequestBody SysDictDetail sysDictDetail){
    return new R<>(sysDictDetailService.save(sysDictDetail));
  }

  /**
   * 修改数据字典详情
   * @param sysDictDetail 数据字典详情
   * @return R
   */
  @ApiOperation("修改数据字典详情")
  @PostMapping("/update")
  public R updateById(@RequestBody SysDictDetail sysDictDetail){
    return new R<>(sysDictDetailService.updateById(sysDictDetail));
  }

  /**
   * 通过ids删除数据字典详情
   * @return R
   */
  @PostMapping("/delete")
  public R delete(@RequestBody Long[] detailIds){
    return new R<>(sysDictDetailService.removeByIds(Arrays.asList(detailIds)));
  }

}
