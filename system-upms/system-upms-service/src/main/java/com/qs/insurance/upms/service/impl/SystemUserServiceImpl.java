package com.qs.insurance.upms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qs.insurance.upms.entity.SystemUser;
import com.qs.insurance.upms.dao.SystemUserMapper;
import com.qs.insurance.upms.service.SystemUserService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.Optional;

/**
 * 系统用户
 *
 * @author wb
 * @date 2020-12-03 23:16:39
 */
@Service("systemUserService")
@AllArgsConstructor
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements SystemUserService {
    private final SystemUserMapper systemUserMapper;

    @Override
    public SystemUser loginIn(String username,String password) {
        //登錄功能
        SystemUser systemUser1=this.systemUserMapper.queryByMobile(username);
        if (!Optional.ofNullable(systemUser1).isPresent()){
            throw new RuntimeException("手机号不存在");
        }
        if (!password.equals(systemUser1.getPassword())){
            throw new RuntimeException("用户名或密码错误");
        }
        return systemUser1;
    }
}
