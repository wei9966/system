package com.qs.insurance.message.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 短信内容模块
 *
 * @author wb
 * @date 2020-12-03 22:14:59
 */
@Data
@TableName("short_message_content")
@EqualsAndHashCode(callSuper = true)
public class ShortMessageContent extends Model<ShortMessageContent> {
private static final long serialVersionUID=1L;

/**
 * 
 */
        @TableId
                @ApiModelProperty(hidden = false, value = "")
private Long id;
/**
 * 短信主表id
 */
                @ApiModelProperty(hidden = false, value = "短信主表id")
private Long messageId;
/**
 * 获取的手机号
 */
                @ApiModelProperty(hidden = false, value = "获取的手机号")
private String phoneNum;
/**
 * 获取的短信内容
 */
                @ApiModelProperty(hidden = false, value = "获取的短信内容")
private String codeContent;
/**
 * 获取时间
 */
                @TableField(fill = FieldFill.INSERT)
                @ApiModelProperty(hidden = true, value = "获取时间")
private Date createTime;
/**
 * 最新获取时间
 */
                    @TableField(fill = FieldFill.UPDATE)
            @ApiModelProperty(hidden = true, value = "最新获取时间")
private Date updateTime;
    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 主键值
 */
@Override
protected Serializable pkVal(){
        return this.id;
        }
}
