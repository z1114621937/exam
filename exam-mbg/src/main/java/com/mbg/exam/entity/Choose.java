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
 * @since 2022-03-14
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
    private String subject;

    @ApiModelProperty(value = "问题")
    private String question;

    @ApiModelProperty(value = "选择A")
    @TableField("answerA")
    private String answera;

    @ApiModelProperty(value = "选择B")
    @TableField("answerB")
    private String answerb;

    @ApiModelProperty(value = "选择C")
    @TableField("answerC")
    private String answerc;

    @ApiModelProperty(value = "选择D")
    @TableField("answerD")
    private String answerd;

    @ApiModelProperty(value = "正确答案")
    private String right;

    @ApiModelProperty(value = "题目解析")
    private String analysis;

    @ApiModelProperty(value = "分数")
    private Integer score;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @ApiModelProperty(value = "状态（1是单选  2是多选）")
    private Integer state;


}
