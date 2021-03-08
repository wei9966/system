package com.qs.insurance.upms.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @Date 2020/5/6 2:54 下午
 * @Description :路由配置表
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_route_conf")
public class SysRouteConf extends Model<SysRouteConf> {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 路由前缀
     */
    private String gatewayPrefix;
    /**
     * 路由名称
     */
    private String routeName;
    /**
     * 路由ID
     */
    private String routeId;
    /**
     * 断言
     */
    private String predicates;
    /**
     * 过滤器
     */
    private String filters;
    /**
     *
     */
    private String uri;
    /**
     * 排序
     */
    @TableField(value = "`order`")
    private Integer order;
    /**
     *
     */
    @TableField(fill = FieldFill.INSERT)
    private Byte isUse;
    /**
     *
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Byte isDeleted;
    /**
     * 机构uuid
     */
    @TableField(fill = FieldFill.INSERT)
    private Long orgId;
    /**
     * 创建人uuid
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createUserId;
    /**
     *
     */
    @TableField(fill = FieldFill.INSERT)
    private String createUserName;
    /**
     *
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     *
     */
    @TableField(fill = FieldFill.UPDATE)
    private Long updateUserId;
    /**
     *
     */
    @TableField(fill = FieldFill.UPDATE)
    private String updateUserName;
    /**
     *
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
