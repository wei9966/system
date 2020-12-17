package com.qs.insurance.message.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qs.insurance.message.entity.ShortMessageContent;
import org.apache.ibatis.annotations.Mapper;

/**
 * 短信获取记录
 *
 * @author wb
 * @date 2020-12-18 01:22:18
 */
@Mapper
public interface ShortMessageContentMapper extends BaseMapper<ShortMessageContent> {

}
