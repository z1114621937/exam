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
@TableName("ex_listen_fu")
@ApiModel(value="ListenFu对象", description="")
public class ListenFu implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "科目")
    private String subject;

    @ApiModelProperty(value = "听力")
    private String data;

    @ApiModelProperty(value = "听力问题")
    private String question;

    @TableField("answerA")
    private String answera;

    @TableField("answerB")
    private String answerb;

    @TableField("answerC")
    private String answerc;

    @TableField("answerD")
    private String answerd;

    @ApiModelProperty(value = "正确选项")
    private String right;

    @ApiModelProperty(value = "试题解析")
    private String analysis;

    @ApiModelProperty(value = "分数")
    private Integer score;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private Integer state;

    @ApiModelProperty(value = "试卷id")
    private Integer paperId;


}
