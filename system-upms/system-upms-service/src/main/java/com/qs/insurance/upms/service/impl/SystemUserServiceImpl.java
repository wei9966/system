package com.qs.insurance.upms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qs.insurance.system.common.core.utils.R;
import com.qs.insurance.upms.dao.SystemUserMapper;
import com.qs.insurance.upms.entity.SystemUser;
import com.qs.insurance.upms.service.SysUserTokenService;
import com.qs.insurance.upms.service.SystemUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
    private final SysUserTokenService sysUserTokenService;
    @Override
    public R loginIn(String username, String password) {
        LambdaQueryWrapper<SystemUser> lambda = Wrappers.<SystemUser>query().lambda();
        lambda.eq(SystemUser::getName,username).or().eq(SystemUser::getPhone,username);
        //登錄功能
        SystemUser systemUser = this.getOne(lambda);
        if (!Optional.ofNullable(systemUser).isPresent()){
            throw new RuntimeException("账号或手机号不存在");
        }
        //TODO 后续加上密码加密校验 暂定MD5
        if (!password.equals(systemUser.getPassword())){
            throw new RuntimeException("用户名或密码错误");
        }
     return    sysUserTokenService.createToken(systemUser.getId());
    }
    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return baseMapper.queryAllMenuId(userId);
    }

}
