package com.mbg.exam.entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ks_student")
@ApiModel(value="Student对象", description="")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "账号")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "学号")
    private String stuNum;

    @ApiModelProperty(value = "头像")
    private String picture;

    // 创建时间：希望在添加数据的时候填充：当前时间
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    // 修改时间：希望在添加数据、修改数据的时候填充：当前时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyDate;

    @ApiModelProperty(value = "学校")
    private String school;

    @ApiModelProperty(value = "班级")
    private String classes;

    @ApiModelProperty(value = "是否被删除")
    private Integer stateDe;

    private Integer staTe;
}
