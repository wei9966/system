package com.qs.insurance.upms.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户
 *
 * @author wb
 * @date 2020-12-03 23:16:39
 */
@Data
@TableName("system_user")
@EqualsAndHashCode(callSuper = true)
public class SystemUser extends Model<SystemUser> {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    @ApiModelProperty(hidden = false, value = "主键 ")
    private Long id;
    /**
     * 用户名
     */
    @ApiModelProperty(hidden = false, value = "用户名")
    private String name;
    /**
     * 密码
     */
    @ApiModelProperty(hidden = false, value = "密码")
    private String password;
    /**
     * 手机号
     */
    @ApiModelProperty(hidden = false, value = "手机号")
    private String phone;
    /**
     * 邮箱
     */
    @ApiModelProperty(hidden = false, value = "邮箱")
    private String email;
    /**
     * 是否删除
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = true, value = "是否删除")
    private Byte isDeleted;
    /**
     * 是否启用
     */
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = true, value = "是否启用")
    private Byte isUse;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = true, value = "创建时间")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty(hidden = true, value = "更新时间")
    private Date updateTime;

    /**
     * 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
