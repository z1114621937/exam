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
@TableName("tm_mingci")
@ApiModel(value="Mingci对象", description="")
public class Mingci implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "问题")
    private String mtQuestion;

    @ApiModelProperty(value = "正确答案")
    private String mtRight;

    @ApiModelProperty(value = "题目解析")
    private String mtAnalysis;

    @ApiModelProperty(value = "分数")
    private Integer mtScore;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @ApiModelProperty(value = "科目")
    private String mtSubject;

    @ApiModelProperty(value = "状态（1是名词解析 2是论述 3是计算题 4是分录  5是资料 6是程序）")
    private Integer mtState;

    @ApiModelProperty(value = "是否被删除")
    private Integer stateDe;

    @ApiModelProperty(value = "难易")
    private String mtLevel;


}
