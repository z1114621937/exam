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
@TableName("tm_yue")
@ApiModel(value="Yue对象", description="")
public class Yue implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String yueSubject;

    private String yueQuestion;

    private String yueQue1;

    private String yueAnswer1;

    private String yueRight1;

    private String yueQue2;

    private String yueAnswer2;

    private String yueRight2;

    private String yueQue3;

    private String yueAnswer3;

    private String yueRight3;

    private String yueQue4;

    private String yueAnswer4;

    private String yueRight4;

    private String yueQue5;

    private String yueAnswer5;

    private String yueRight5;

    private Integer yueScore;

    private String yueAnalysis;

    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    // 修改时间：希望在添加数据、修改数据的时候填充：当前时间


    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyDate;

    private String stateDe;

    private String yueLevel;


}
