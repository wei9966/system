package com.qs.insurance.message.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qs.insurance.message.entity.ShortMessageLoginRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * 短信登录记录
 *
 * @author wb
 * @date 2020-12-03 20:04:18
 */
@Mapper
public interface ShortMessageLoginRecordMapper extends BaseMapper<ShortMessageLoginRecord> {

}
