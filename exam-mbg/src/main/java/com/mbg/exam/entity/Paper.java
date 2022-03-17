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
@TableName("ks_paper")
@ApiModel(value="Paper对象", description="")
public class Paper implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "试卷名称")
    private String examName;

    @ApiModelProperty(value = "组卷方式")
    private String manner;

    @ApiModelProperty(value = "创建人   teacher表")
    private String teaName;

    @ApiModelProperty(value = "卷子总分")
    private Integer score;

    @ApiModelProperty(value = "试卷类型")
    private String subject;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @ApiModelProperty(value = "0是为未开始 1是开始  2是已经结束")
    private Integer state;

    @ApiModelProperty(value = "考试开始时间")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "考试结束时间")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "考试时长")
    private String examTime;

    @ApiModelProperty(value = "考试场次")
    private Integer num;

    @ApiModelProperty(value = "是否删除")
    private Integer stateDe;


}
