package com.qs.insurance.message.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * (ShortMessageRecord)实体类
 *
 * @author wb
 * @since 2020-12-03 17:09:22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("short_message")
public class ShortMessage extends Model<ShortMessage> implements Serializable {
    private static final long serialVersionUID = 597015624684470384L;

    private Long id;

    private String phoneNumber;

    private Date updateTime;

    private Byte isUse;

    private Byte isDeleted;

    private Date createTime;

    private Long userId;

    private String password;


}