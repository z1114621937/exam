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
 * @since 2022-03-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ks_answer")
@ApiModel(value="Answer对象", description="")
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "学生答案")
    private String answer;

    private String answer2;

    private String answer3;

    private String answer4;

    private String answer5;

    @ApiModelProperty(value = "试卷id")
    private String paperId;

    @ApiModelProperty(value = "学生id")
    private String stuId;

    @ApiModelProperty(value = "是否正确")
    private Integer isTrue;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @ApiModelProperty(value = "0是choose 1是fill 2是mingci ")
    private Integer state;

    @ApiModelProperty(value = "是否被删除")
    private Integer stateDe;


}
