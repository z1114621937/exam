package com.mbg.exam.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
@TableName("tm_choose")
@ApiModel(value="Choose对象", description="")
public class Choose implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "考试科目")
    private String ctSubject;

    @ApiModelProperty(value = "问题")
    private String ctQuestion;

    @ApiModelProperty(value = "选择A")
    @TableField("ct_answerA")
    private String ctAnswera;

    @ApiModelProperty(value = "选择B")
    @TableField("ct_answerB")
    private String ctAnswerb;

    @ApiModelProperty(value = "选择C")
    @TableField("ct_answerC")
    private String ctAnswerc;

    @ApiModelProperty(value = "选择D")
    @TableField("ct_answerD")
    private String ctAnswerd;

    @ApiModelProperty(value = "正确答案")
    private String ctRight;

    @ApiModelProperty(value = "题目解析")
    private String ctAnalysis;

    @ApiModelProperty(value = "分数")
    private Integer ctScore;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @ApiModelProperty(value = "状态（1是单选  2是多选）")
    private Integer ctState;

    @ApiModelProperty(value = "是否删除")
    private Integer stateDe;

    @ApiModelProperty(value = "难易")
    private String ctLevel;


}
