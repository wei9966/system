package com.qs.insurance.message.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qs.insurance.message.entity.ShortMessageContent;
import org.apache.ibatis.annotations.Mapper;

/**
 * 短信内容模块
 *
 * @author wb
 * @date 2020-12-03 22:14:59
 */
@Mapper
public interface ShortMessageContentMapper extends BaseMapper<ShortMessageContent> {

}
