package com.qs.insurance.upms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Create By WeiBin on 2020/12/4 16:03
 *
 * 
*/

/**
 * 系统用户Token
 */
@Data
@TableName(value = "system.sys_user_token")
public class SysUserToken implements Serializable {
    @TableId(value = "user_id", type = IdType.INPUT)
    private Long userId;

    /**
     * token
     */
    @TableField(value = "token")
    private String token;

    /**
     * 过期时间
     */
    @TableField(value = "expire_time")
    private Date expireTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_USER_ID = "user_id";

    public static final String COL_TOKEN = "token";

    public static final String COL_EXPIRE_TIME = "expire_time";

    public static final String COL_UPDATE_TIME = "update_time";
}