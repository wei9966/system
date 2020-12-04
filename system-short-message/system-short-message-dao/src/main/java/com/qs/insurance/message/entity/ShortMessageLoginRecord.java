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
 * 短信登录记录
 *
 * @author wb
 * @date 2020-12-03 20:04:18
 */
@Data
@TableName("short_message_login_record")
@EqualsAndHashCode(callSuper = true)
public class ShortMessageLoginRecord extends Model<ShortMessageLoginRecord> {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    @ApiModelProperty(hidden = false, value = "")
    private Long id;
    /**
     *
     */
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = true, value = "")
    private Date createTime;
    /**
     *
     */
    @ApiModelProperty(hidden = true, value = "")
    private Long messageId;
    /**
     * 登录结果
     */
    @ApiModelProperty(hidden = true, value = "登录结果")
    private String loginResult;

    /**
     * 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
