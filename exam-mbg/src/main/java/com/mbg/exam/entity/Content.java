package com.mbg.exam.entity;

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
@TableName("ks_content")
@ApiModel(value="Content对象", description="")
public class Content implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "发布者名字  teacher表")
    private String teaName;

    @ApiModelProperty(value = "公告内容")
    private String content;

    @ApiModelProperty(value = "学校")
    private String school;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    // 修改时间：希望在添加数据、修改数据的时候填充：当前时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyDate;


}
