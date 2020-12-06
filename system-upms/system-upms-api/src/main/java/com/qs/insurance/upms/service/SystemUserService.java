package com.qs.insurance.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qs.insurance.system.common.core.utils.R;
import com.qs.insurance.upms.entity.SystemUser;

import java.util.List;

/**
 * 系统用户
 *
 * @author wb
 * @date 2020-12-03 23:16:39
 */
public interface SystemUserService extends IService<SystemUser> {

    R loginIn(String username, String password);

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);
}
