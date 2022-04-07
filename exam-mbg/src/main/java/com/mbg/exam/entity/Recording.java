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
 * @since 2022-03-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ex_recording")
@ApiModel(value="Recording对象", description="")
public class Recording implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "类型题目 1.单选 2.多选 3.判断 4.填空 5.问答")
    private Integer type;

    @ApiModelProperty(value = "哪个试卷的id")
    private Integer paperId;

    @ApiModelProperty(value = "是否被删除")
    private Integer state;

    @ApiModelProperty(value = "对应题目的题号")
    private Integer exId;

    @ApiModelProperty(value = "自定义的题目优先级")
    private Integer exLevel;
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    @TableField(fill = FieldFill.INSERT)
    private Date modifyDate;


}
