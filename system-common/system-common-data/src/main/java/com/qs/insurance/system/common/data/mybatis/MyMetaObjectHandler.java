package com.qs.insurance.system.common.data.mybatis;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.qs.insurance.system.common.core.constant.Constant;
import com.qs.insurance.system.common.security.utils.AppSecurityUtils;
import com.qs.insurance.upms.entity.SystemUser;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *
 * @Author jhy
 * @Date  2020/5/6 9:36 上午
 * @Description :自定义公共字段填充处理器
 *
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

 /**
  *
  * @Author jhy
  * @Date  2020/5/6 9:37 上午
  * @Description :插入操作自动填充
  *
  */
    @Override
    public void insertFill(MetaObject metaObject) {
        Object createUserName = getFieldValByName("createUserName", metaObject);
        Object createUserId = getFieldValByName("createUserId", metaObject);
        Object createTime = getFieldValByName("createTime", metaObject);
        Object isDeteled = getFieldValByName("isDeleted", metaObject);
        Object isUse = getFieldValByName("isUse", metaObject);
        Date currentDate = DateUtil.date();
//        MqmcUser user = SecurityUtils.getUser();
//        if(null ==user){
//            setFieldValByName("createTime", currentDate, metaObject);
//            setFieldValByName("isDeleted", Constant.BYTE_NO, metaObject);
//        }else{
//        CurrentUser currentUser = SecurityUtils;
        SystemUser user = AppSecurityUtils.getUser();
        if (createUserName == null||StringUtils.isBlank(createUserName.toString())) {
            String name = ObjectUtil.isNull(user) ? "未获取" : StrUtil.isBlank(user.getName()) ? user.getName() : user.getName();
            setFieldValByName("createUserName", name, metaObject);
        }
        if (createUserId == null) {
            Long userId = ObjectUtil.isNull(user) ? null : user.getId();
            setFieldValByName("createUserId", userId, metaObject);
        }
        if (createTime == null) {
            setFieldValByName("createTime", currentDate, metaObject);
        }
        if (isDeteled == null) {
            setFieldValByName("isDeleted", Constant.BYTE_NO, metaObject);
        }
        if (isUse == null) {
            setFieldValByName("isUse", Constant.BYTE_YES, metaObject);
        }
    }

/**
 *
 * @Author jhy
 * @Date  2020/5/6 9:36 上午
 * @Description :修改操作自动填充
 *
 */
    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateUserName = getFieldValByName("updateUserName", metaObject);
        Object updateUserId = getFieldValByName("updateUserId", metaObject);
        Object updateTime = getFieldValByName("updateTime", metaObject);
        SystemUser user = AppSecurityUtils.getUser();
        DateTime currentDate = DateUtil.date();
        if (null==updateUserName||StringUtils.isBlank(updateUserName.toString())) {
            String name = ObjectUtil.isNull(user) ? "未获取" : StrUtil.isBlank(user.getName()) ? user.getName() : user.getName();
            setFieldValByName("updateUserName", name, metaObject);
        }
        if (updateUserId == null) {
            Long userId = ObjectUtil.isNull(user) ? null : user.getId();
            setFieldValByName("updateUserId", userId, metaObject);
        }
        if (updateTime == null) {
            setFieldValByName("updateTime", currentDate, metaObject);
        }
    }
}
