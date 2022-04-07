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
 * @since 2022-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ks_ku")
@ApiModel(value="Ku对象", description="")
public class Ku implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer chId;

    private Integer fenId;

    private Integer fillId;

    private Integer fullId;

    private Integer listenId;

    private Integer mingci;

    private Integer yueId;

    @ApiModelProperty(value = "老师名字")
    private String teName;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @ApiModelProperty(value = "题库名字")
    private String kuName;

    @ApiModelProperty(value = "学科")
    private String kuSubject;

    @ApiModelProperty(value = "是否删除")
    private Integer stateDe;

    @ApiModelProperty(value = "题库id")
    private Integer tikuId;


}
