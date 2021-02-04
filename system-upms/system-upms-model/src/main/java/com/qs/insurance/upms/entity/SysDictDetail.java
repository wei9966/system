package com.qs.insurance.upms.entity;

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
 * 数据字典详情
 *
 * @author wb
 * @date 2020-12-28 11:03:20
 */
@Data
@TableName("sys_dict_detail")
@EqualsAndHashCode(callSuper = true)
public class SysDictDetail extends Model<SysDictDetail> implements Serializable {
private static final long serialVersionUID=1L;

/**
 * ID
 */
        @TableId
                @ApiModelProperty(hidden = false, value = "ID")
private Long detailId;
/**
 * 字典id
 */
                @ApiModelProperty(hidden = false, value = "字典id")
private Long dictId;
/**
 * 字典标签
 */
                @ApiModelProperty(hidden = false, value = "字典标签")
private String label;
/**
 * 字典值
 */
                @ApiModelProperty(hidden = false, value = "字典值")
private String value;
/**
 * 排序
 */
                @ApiModelProperty(hidden = false, value = "排序")
private Integer dictSort;
/**
 * 创建者
 */
                @ApiModelProperty(hidden = false, value = "创建者")
private String createUserName;
/**
 * 更新者
 */
                @ApiModelProperty(hidden = false, value = "更新者")
private String updateUserName;
/**
 * 创建日期
 */
                @TableField(fill = FieldFill.INSERT)
                @ApiModelProperty(hidden = true, value = "创建日期")
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
protected Serializable pkVal(){
        return this.detailId;
        }
}
