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
 * @since 2022-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ks_grade")
@ApiModel(value="Grade对象", description="")
public class Grade implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "考试id")
    private Integer examId;

    @ApiModelProperty(value = "学号")
    private String stuNum;

    @ApiModelProperty(value = "成绩")
    private Integer grade;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;


}
