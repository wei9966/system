package com.qs.insurance.upms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qs.insurance.upms.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Create By WeiBin on 2020/12/4 16:03
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 查询用户创建的角色ID列表
     */
    List<Long> queryRoleIdList(Long createUserId);
}