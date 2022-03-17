package com.mbg.exam.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("ex_mingci_fu")
@ApiModel(value="MingciFu对象", description="")
public class MingciFu implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "问题")
    private String miQuestion;

    @ApiModelProperty(value = "正确答案")
    private String miRight;

    @ApiModelProperty(value = "题目解析")
    private String miAnalysis;

    @ApiModelProperty(value = "分数")
    private Integer miScore;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @ApiModelProperty(value = "科目")
    private String miSubject;

    @ApiModelProperty(value = "状态（1是名词解析 2是论述 3是计算题 4是分录  5是资料 6是程序）")
    private Integer miState;

    @ApiModelProperty(value = "试卷id")
    private Integer paperId;

    @ApiModelProperty(value = "学期")
    private String miSemester;

    @ApiModelProperty(value = "是否被删除")
    private Integer stateDe;

    @ApiModelProperty(value = "难易")
    private String miLevel;


}
