package com.mbg.exam.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
@TableName("ex_full_input_fu")
@ApiModel(value="FullInputFu对象", description="")
public class FullInputFu implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String inSubject;

    private String inData;

    @TableField("answer1A")
    private String answer1a;

    @TableField("answer1B")
    private String answer1b;

    @TableField("answer1C")
    private String answer1c;

    @TableField("answer1D")
    private String answer1d;

    @TableField("answer2A")
    private String answer2a;

    @TableField("answer2B")
    private String answer2b;

    @TableField("answer2C")
    private String answer2c;

    @TableField("answer2D")
    private String answer2d;

    @TableField("answer3A")
    private String answer3a;

    @TableField("answer3B")
    private String answer3b;

    @TableField("answer3C")
    private String answer3c;

    @TableField("answer3D")
    private String answer3d;

    @TableField("answer4A")
    private String answer4a;

    @TableField("answer4B")
    private String answer4b;

    @TableField("answer4C")
    private String answer4c;

    @TableField("answer4D")
    private String answer4d;

    @TableField("answer5A")
    private String answer5a;

    @TableField("answer5B")
    private String answer5b;

    @TableField("answer5C")
    private String answer5c;

    @TableField("answer5D")
    private String answer5d;

    @TableField("answer6A")
    private String answer6a;

    @TableField("answer6B")
    private String answer6b;

    @TableField("answer6C")
    private String answer6c;

    @TableField("answer6D")
    private String answer6d;

    @TableField("answer7A")
    private String answer7a;

    @TableField("answer7B")
    private String answer7b;

    @TableField("answer7C")
    private String answer7c;

    @TableField("answer7D")
    private String answer7d;

    @TableField("answer8A")
    private String answer8a;

    @TableField("answer8B")
    private String answer8b;

    @TableField("answer8C")
    private String answer8c;

    @TableField("answer8D")
    private String answer8d;

    @TableField("answer9A")
    private String answer9a;

    @TableField("answer9B")
    private String answer9b;

    @TableField("answer9C")
    private String answer9c;

    @TableField("answer9D")
    private String answer9d;

    @TableField("answer10A")
    private String answer10a;

    @TableField("answer10B")
    private String answer10b;

    @TableField("answer10C")
    private String answer10c;

    @TableField("answer10D")
    private String answer10d;

    @TableField("answer11A")
    private String answer11a;

    @TableField("answer11B")
    private String answer11b;

    @TableField("answer11C")
    private String answer11c;

    @TableField("answer11D")
    private String answer11d;

    @TableField("answer12A")
    private String answer12a;

    @TableField("answer12B")
    private String answer12b;

    @TableField("answer12C")
    private String answer12c;

    @TableField("answer12D")
    private String answer12d;

    @TableField("answer13A")
    private String answer13a;

    @TableField("answer13B")
    private String answer13b;

    @TableField("answer13C")
    private String answer13c;

    @TableField("answer13D")
    private String answer13d;

    @TableField("answer14A")
    private String answer14a;

    @TableField("answer14B")
    private String answer14b;

    @TableField("answer14C")
    private String answer14c;

    @TableField("answer14D")
    private String answer14d;

    @TableField("answer15A")
    private String answer15a;

    @TableField("answer15B")
    private String answer15b;

    @TableField("answer15C")
    private String answer15c;

    @TableField("answer15D")
    private String answer15d;

    private String right1;

    private String right2;

    private String right3;

    private String right4;

    private String right5;

    private String right6;

    private String right7;

    private String right8;

    private String right9;

    private String right10;

    private String right11;

    private String right12;

    private String right13;

    private String right14;

    @ApiModelProperty(value = "正确选项")
    private String right15;

    @ApiModelProperty(value = "分析")
    private String inAnalysis;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private Integer inState;

    @ApiModelProperty(value = "试卷id")
    private Integer paperId;

    @ApiModelProperty(value = "学期")
    private String inSemester;

    @ApiModelProperty(value = "是否被删除")
    private Integer stateDe;

    @ApiModelProperty(value = "难易")
    private String inLevel;


}
