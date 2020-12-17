package com.qs.insurance.message.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qs.insurance.message.entity.ShortMessageContent;
import com.qs.insurance.message.service.ShortMessageContentService;
import com.qs.insurance.system.common.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 短信获取记录
 *
 * @author wb
 * @date 2020-12-18 01:22:18
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/shortmessagecontent")
@Api(value = "短信获取记录", tags = "短信获取记录")
public class ShortMessageContentController {

  private final ShortMessageContentService shortMessageContentService;

  /**
   * 分页查询
   * @return
   */
  @ApiOperation("分页查询短信获取记录")
  @GetMapping("/list")
  public R getShortMessageContentPage(@ApiParam("当前页数") @RequestParam("pageNo") Integer pageNo,
                                      @ApiParam("每页显示条数")@RequestParam("pageSize")Integer pageSize) {
    Page<ShortMessageContent> shortMessageContentPage = new Page<>(pageNo, pageSize);
    LambdaQueryWrapper<ShortMessageContent> shortMessageContentWrapper = Wrappers.<ShortMessageContent>query().lambda();
    return  new R<>(shortMessageContentService.page(shortMessageContentPage,shortMessageContentWrapper));
  }


  /**
   * 通过id查询短信获取记录
   * @param id id
   * @return R
   */
  @ApiOperation("通过id查询短信获取记录")
  @GetMapping("/info/{id}")
  public R getById(@PathVariable("id") Long id){
    return new R<>(shortMessageContentService.getById(id));
  }

  /**
   * 新增短信获取记录
   * @param shortMessageContent 短信获取记录
   * @return R
   */
  @ApiOperation("新增短信获取记录")
  @PostMapping("/save")
  public R save(@RequestBody ShortMessageContent shortMessageContent){
    return new R<>(shortMessageContentService.save(shortMessageContent));
  }

  /**
   * 修改短信获取记录
   * @param shortMessageContent 短信获取记录
   * @return R
   */
  @ApiOperation("修改短信获取记录")
  @PostMapping("/update")
  public R updateById(@RequestBody ShortMessageContent shortMessageContent){
    return new R<>(shortMessageContentService.updateById(shortMessageContent));
  }

  /**
   * 通过ids删除短信获取记录
   * @return R
   */
  @PostMapping("/delete")
  public R delete(@RequestBody Long[] ids){
      shortMessageContentService.removeByIds(Arrays.asList(ids));

    return new R();
  }

}
