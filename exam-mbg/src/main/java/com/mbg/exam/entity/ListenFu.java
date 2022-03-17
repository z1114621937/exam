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
@TableName("ex_listen_fu")
@ApiModel(value="ListenFu对象", description="")
public class ListenFu implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "科目")
    private String liSubject;

    @ApiModelProperty(value = "听力")
    private String liData;

    @ApiModelProperty(value = "听力问题")
    private String liQuestion;

    @TableField("li_answerA")
    private String liAnswera;

    @TableField("li_answerB")
    private String liAnswerb;

    @TableField("li_answerC")
    private String liAnswerc;

    @TableField("li_answerD")
    private String liAnswerd;

    @ApiModelProperty(value = "正确选项")
    private String liRight;

    @ApiModelProperty(value = "试题解析")
    private String liAnalysis;

    @ApiModelProperty(value = "分数")
    private Integer liScore;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private Integer liState;

    @ApiModelProperty(value = "试卷id")
    private Integer paperId;

    @ApiModelProperty(value = "学期")
    private String liSemester;

    @ApiModelProperty(value = "是否被删除")
    private Integer stateDe;

    @ApiModelProperty(value = "难易")
    private String liLevel;


}
