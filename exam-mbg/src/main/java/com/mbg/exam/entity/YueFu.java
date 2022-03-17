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
@TableName("ex_yue_fu")
@ApiModel(value="YueFu对象", description="")
public class YueFu implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String yueSubject;

    private String yueQuestion;

    private String yueQue1;

    private String yueAnswer1;

    private String yueRight1;

    private String yueQue2;

    private String yueAnswer2;

    private String yueRight2;

    private String yueQue3;

    private String yueAnswer3;

    private String yueRight3;

    private String yueQue4;

    private String yueAnswer4;

    private String yueRight4;

    private String yueQue5;

    private String yueAnswer5;

    private String yueRight5;

    private Integer yueScore;

    private String yueAnalysis;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private String stateDe;

    private String yueLevel;

    private Integer paperId;


}
