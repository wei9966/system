package com.qs.insurance.system.common.data.mybatis;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
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
        Object orgId = getFieldValByName("orgId", metaObject);
        Object orgName = getFieldValByName("orgName", metaObject);
        Date currentDate = DateUtil.date();
//        MqmcUser user = SecurityUtils.getUser();
//        if(null ==user){
//            setFieldValByName("createTime", currentDate, metaObject);
//            setFieldValByName("isDeleted", Constant.BYTE_NO, metaObject);
//        }else{
////        CurrentUser currentUser = SecurityUtils.getCurrentUser();
//
//        if (createUserName == null) {
//            String name = ObjectUtil.isNull(user) ? "未获取" : StrUtil.isBlank(user.getName()) ? user.getUsername() : user.getName();
//            setFieldValByName("createUserName", name, metaObject);
//        }
//        if (createUserId == null) {
//            Long userId = ObjectUtil.isNull(user) ? null : user.getId();
//            setFieldValByName("createUserId", userId, metaObject);
//        }
//        if (createTime == null) {
//            setFieldValByName("createTime", currentDate, metaObject);
//        }
//        if (isDeteled == null) {
//            setFieldValByName("isDeleted", Constant.BYTE_NO, metaObject);
//        }
//        if (isUse == null) {
//            setFieldValByName("isUse", Constant.BYTE_YES, metaObject);
//        }
//        if (orgId == null) {
//            Long currentOrgId = ObjectUtil.isNull(user) ? null : user.getOrgId();
//            setFieldValByName("orgId", currentOrgId, metaObject);
//        }
//        if (orgName == null) {
//            String currentOrgName = ObjectUtil.isNull(currentUser) ? null : currentUser.getOrgName();
//            setFieldValByName("orgName", currentOrgName, metaObject);
//        }
//        }
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
////        MqmcUser user = SecurityUtils.getUser();
//        DateTime currentDate = DateUtil.date();
//        if (updateUserName == null) {
//            String name = ObjectUtil.isNull(user) ? "未获取" : StrUtil.isBlank(user.getName()) ? user.getUsername() : user.getName();
//            setFieldValByName("updateUserName", name, metaObject);
//        }
//        if (updateUserId == null) {
//            Long userId = ObjectUtil.isNull(user) ? null : user.getId();
//            setFieldValByName("updateUserId", userId, metaObject);
//        }
//        if (updateTime == null) {
//            setFieldValByName("updateTime", currentDate, metaObject);
//        }
    }
}
