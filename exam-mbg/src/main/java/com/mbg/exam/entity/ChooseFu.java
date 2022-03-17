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
@TableName("ex_choose_fu")
@ApiModel(value="ChooseFu对象", description="")
public class ChooseFu implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "考试科目")
    private String cSubject;

    @ApiModelProperty(value = "问题")
    private String cQuestion;

    @ApiModelProperty(value = "选择A")
    @TableField("c_answerA")
    private String cAnswera;

    @ApiModelProperty(value = "选择B")
    @TableField("c_answerB")
    private String cAnswerb;

    @ApiModelProperty(value = "选择C")
    @TableField("c_answerC")
    private String cAnswerc;

    @ApiModelProperty(value = "选择D")
    @TableField("c_answerD")
    private String cAnswerd;

    @ApiModelProperty(value = "正确答案")
    private String cRight;

    @ApiModelProperty(value = "题目解析")
    private String cAnalysis;

    @ApiModelProperty(value = "分数")
    private Integer cScore;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @ApiModelProperty(value = "状态（1是单选  2是多选）")
    private Integer cState;

    @ApiModelProperty(value = "试卷id")
    private Integer paperId;

    @ApiModelProperty(value = "学期 （比如大一下啥的）")
    private String cSemester;

    @ApiModelProperty(value = "是否被删除")
    private Integer stateDe;

    @ApiModelProperty(value = "难易层度")
    private String cLevel;


}
