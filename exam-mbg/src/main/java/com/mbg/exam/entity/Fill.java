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
@TableName("tm_fill")
@ApiModel(value="Fill对象", description="")
public class Fill implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "问题")
    private String ftQuestion;

    @ApiModelProperty(value = "科目")
    private String ftSubject;

    @ApiModelProperty(value = "正确答案")
    private String ftRight;

    @ApiModelProperty(value = "题目解析")
    private String ftAnalysis;

    @ApiModelProperty(value = "分数")
    private Integer ftScore;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @ApiModelProperty(value = "状态 （1是填空  2是判断）")
    private Integer ftState;

    @ApiModelProperty(value = "是否被删除")
    private Integer stateDe;

    @ApiModelProperty(value = "难易")
    private String ftLevel;


}
