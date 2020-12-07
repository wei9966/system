package com.qs.insurance.message.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qs.insurance.message.entity.ShortMessage;
import org.apache.ibatis.annotations.Mapper;

/**
 * (ShortMessageRecord)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-03 17:17:58
 */
@Mapper
public interface ShortMessageMapper extends BaseMapper<ShortMessage> {

}