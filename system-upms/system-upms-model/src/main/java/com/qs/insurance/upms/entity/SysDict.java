package com.qs.insurance.upms.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据字典
 *
 * @author wb
 * @date 2020-12-28 10:58:10
 */
@Data
@TableName("sys_dict")
@EqualsAndHashCode(callSuper = true)
@Document(indexName = "dict",type = "sys_dict", shards = 1, replicas = 0)
//indexName索引名称 可以理解为数据库名 必须为小写 不然会报org.elasticsearch.indices.InvalidIndexNameException异常
//type类型 可以理解为表名
public class SysDict extends Model<SysDict> implements Serializable {
private static final long serialVersionUID=1L;

/**
 * ID
 */
        @TableId
                @ApiModelProperty(hidden = false, value = "ID")
        @Id
private Long dictId;
/**
 * 字典名称
 */
                @ApiModelProperty(hidden = false, value = "字典名称")
private String name;
/**
 * 描述
 */
                @ApiModelProperty(hidden = false, value = "描述")
private String description;
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
        return this.dictId;
        }
}
