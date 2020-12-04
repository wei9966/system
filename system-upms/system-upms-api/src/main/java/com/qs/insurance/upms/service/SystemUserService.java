package com.qs.insurance.upms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qs.insurance.upms.entity.SystemUser;

/**
 * 系统用户
 *
 * @author wb
 * @date 2020-12-03 23:16:39
 */
public interface SystemUserService extends IService<SystemUser> {

    SystemUser loginIn(String username,String password);
}
