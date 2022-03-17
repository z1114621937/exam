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
@TableName("ex_fill_fu")
@ApiModel(value="FillFu对象", description="")
public class FillFu implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "问题")
    private String fiQuestion;

    @ApiModelProperty(value = "科目")
    private String fiSubject;

    @ApiModelProperty(value = "正确答案")
    private String fiRight;

    @ApiModelProperty(value = "题目解析")
    private String fiAnalysis;

    @ApiModelProperty(value = "分数")
    private Integer fiScore;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @ApiModelProperty(value = "状态 （1是填空  2是判断）")
    private Integer fiState;

    @ApiModelProperty(value = "试卷id")
    private Integer paperId;

    @ApiModelProperty(value = "学期")
    private String fiSemester;

    @ApiModelProperty(value = "是否被删除")
    private Integer stateDe;

    @ApiModelProperty(value = "难易层度")
    private String fiLevel;


}
