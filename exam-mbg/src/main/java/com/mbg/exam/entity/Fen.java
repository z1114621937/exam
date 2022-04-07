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
@TableName("tm_fen")
@ApiModel(value="Fen对象", description="")
public class Fen implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String fenSubject;

    private String fenQuestion;

    private String fenAnswer1;

    private String fenRight1;

    private String fenAnswer2;

    private String fenRight2;

    private String fenAnswer3;

    private String fenRight3;

    private String fenAnswer4;

    private String fenRight4;

    private String fenAnswer5;

    private String fenRight5;

    @ApiModelProperty(value = "题目分析")
    private String fenAnalysis;

    @ApiModelProperty(value = "题目分数")
    private Integer fenScore;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @ApiModelProperty(value = "是否被删除")
    private Integer stateDe;

    @ApiModelProperty(value = "难易程度")
    private String fenLevel;

    private Integer fState;


}
