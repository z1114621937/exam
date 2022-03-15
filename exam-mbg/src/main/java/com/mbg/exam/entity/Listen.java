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
 * @since 2022-03-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tm_listen")
@ApiModel(value="Listen对象", description="")
public class Listen implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "科目")
    private String ltSubject;

    @ApiModelProperty(value = "听力")
    private String ltData;

    @ApiModelProperty(value = "听力问题")
    private String ltQuestion;

    @TableField("lt_answerA")
    private String ltAnswera;

    @TableField("lt_answerB")
    private String ltAnswerb;

    @TableField("lt-answerC")
    private String lt-answerc;

    @TableField("lt_answerD")
    private String ltAnswerd;

    @ApiModelProperty(value = "正确选项")
    private String ltRight;

    @ApiModelProperty(value = "试题解析")
    private String ltAnalysis;

    @ApiModelProperty(value = "分数")
    private Integer ltScore;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private Integer ltState;

    @ApiModelProperty(value = "是否被删除")
    private Integer stateDe;


}
