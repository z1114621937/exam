package com.mbg.exam.entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
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
@TableName("ks_paper")
@ApiModel(value="Paper对象", description="")
public class Paper implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "试卷名称")
    private String examName;

    @ApiModelProperty(value = "组卷方式")
    private String manner;

    @ApiModelProperty(value = "创建人   teacher表")
    private String teaName;

    @ApiModelProperty(value = "卷子总分")
    private Integer score;

    @ApiModelProperty(value = "试卷类型")
    private String subject;

    // 创建时间：希望在添加数据的时候填充：当前时间
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    // 修改时间：希望在添加数据、修改数据的时候填充：当前时间


    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyDate;

    @ApiModelProperty(value = "0是为未开始 1是开始  2是已经结束")
    private Integer state;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "考试开始时间")
    private LocalDateTime startTime;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "考试结束时间")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "考试时长")
    private String examTime;

    @ApiModelProperty(value = "考试场次")
    private Integer num;

    @ApiModelProperty(value = "是否删除")
    private Integer stateDe;


    @TableField(exist = false)
    private List<ChooseFu> chooseFus;

    @TableField(exist = false)
    private List<FillFu> fillFus;

    @TableField(exist = false)
    private List<FullInputFu> fullInputFus;

    @TableField(exist = false)
    private List<ListenFu> listenFus;

    @TableField(exist = false)
    private List<MingciFu> mingcis;

    @TableField(exist = false)
    private List<Answer> Answer;

}
