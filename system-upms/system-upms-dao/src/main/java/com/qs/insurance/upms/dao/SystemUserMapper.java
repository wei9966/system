package com.qs.insurance.upms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qs.insurance.upms.entity.SystemUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 系统用户
 *
 * @author wb
 * @date 2020-12-03 23:16:39
 */
@Mapper
public interface SystemUserMapper extends BaseMapper<SystemUser> {

    SystemUser queryByMobile(@Param("phone") String phone);

}
