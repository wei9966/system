package com.qs.insurance.upms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qs.insurance.upms.entity.SystemUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统用户
 *
 * @author wb
 * @date 2020-12-03 23:16:39
 */
@Mapper
public interface SystemUserMapper extends BaseMapper<SystemUser> {

    SystemUser queryByMobile(@Param("phone") String phone);

    /*---------------框架自帶-----------------*/
    /**
     * 查询用户的所有权限
     * @param userId  用户ID
     */
    List<String> queryAllPerms(Long userId);

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 根据用户名，查询系统用户
     */
    SystemUser queryByUserName(String username);
}
