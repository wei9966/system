package com.qs.insurance.upms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qs.insurance.upms.entity.SysUserToken;
import org.apache.ibatis.annotations.Mapper;

/**
 * Create By WeiBin on 2020/12/4 16:03
 */
@Mapper
public interface SysUserTokenMapper extends BaseMapper<SysUserToken> {

    SysUserToken queryByToken(String token);
}