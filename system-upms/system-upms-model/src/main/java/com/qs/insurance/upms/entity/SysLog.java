package com.qs.insurance.upms.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志表
 *
 * @author wb
 * @date 2020-12-28 14:47:03
 */
@Data
@TableName("sys_log")
@EqualsAndHashCode(callSuper = true)
public class SysLog extends Model<SysLog> implements Serializable {
private static final long serialVersionUID=1L;

/**
 * 
 */
        @TableId
                @ApiModelProperty(hidden = false, value = "")
private Long id;
/**
 * 日志类型
 */
                @ApiModelProperty(hidden = false, value = "日志类型")
private Byte type;
/**
 * 日志标题
 */
                @ApiModelProperty(hidden = false, value = "日志标题")
private String title;
/**
 * 
 */
                @ApiModelProperty(hidden = false, value = "")
private String serviceId;
/**
 * 创建者
 */
                @ApiModelProperty(hidden = false, value = "创建者")
private String createBy;
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
 * 操作IP地址
 */
                @ApiModelProperty(hidden = true, value = "操作IP地址")
private String remoteAddr;
/**
 * 用户代理
 */
                @ApiModelProperty(hidden = true, value = "用户代理")
private String userAgent;
/**
 * 请求URI
 */
                @ApiModelProperty(hidden = true, value = "请求URI")
private String requestUri;
/**
 * 操作方式
 */
                @ApiModelProperty(hidden = true, value = "操作方式")
private String method;
/**
 * 操作提交的数据
 */
                @ApiModelProperty(hidden = true, value = "操作提交的数据")
private String params;
/**
 * 执行时间
 */
                @ApiModelProperty(hidden = true, value = "执行时间")
private String time;
/**
 * 删除标记
 */
            @TableLogic
            @TableField(fill = FieldFill.INSERT)
                @ApiModelProperty(hidden = true, value = "删除标记")
private Byte isDeleted;
/**
 * 异常信息
 */
                @ApiModelProperty(hidden = true, value = "异常信息")
private String exception;
/**
 * 
 */
                @ApiModelProperty(hidden = true, value = "")
private Long tenantId;
/**
 * 所属区域
 */
                @ApiModelProperty(hidden = true, value = "所属区域")
private String logArea;
/**
 * 创建者账号
 */
                @ApiModelProperty(hidden = true, value = "创建者账号")
private String createNumber;

/**
 * 主键值
 */
@Override
protected Serializable pkVal(){
        return this.id;
        }
}
