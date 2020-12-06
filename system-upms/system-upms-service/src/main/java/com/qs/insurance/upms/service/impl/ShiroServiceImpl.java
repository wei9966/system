/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.qs.insurance.upms.service.impl;

import com.qs.insurance.system.common.core.constant.RenRenConstant;
import com.qs.insurance.upms.dao.SysMenuMapper;
import com.qs.insurance.upms.dao.SysUserTokenMapper;
import com.qs.insurance.upms.dao.SystemUserMapper;
import com.qs.insurance.upms.entity.SysMenu;
import com.qs.insurance.upms.entity.SysUserToken;
import com.qs.insurance.upms.entity.SystemUser;
import com.qs.insurance.upms.service.ShiroService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private SysMenuMapper sysMenuDao;
    @Autowired
    private SystemUserMapper sysUserDao;
    @Autowired
    private SysUserTokenMapper sysUserTokenDao;

    @Override
    public Set<String> getUserPermissions(long userId) {
        List<String> permsList;

        //系统管理员，拥有最高权限
        if(userId == RenRenConstant.SUPER_ADMIN){
            List<SysMenu> menuList = sysMenuDao.selectList(null);
            permsList = new ArrayList<>(menuList.size());
            for(SysMenu menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else{
            permsList = sysUserDao.queryAllPerms(userId);
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public SysUserToken queryByToken(String token) {
        return sysUserTokenDao.queryByToken(token);
    }

    @Override
    public SystemUser queryUser(Long userId) {
        return sysUserDao.selectById(userId);
    }
}
