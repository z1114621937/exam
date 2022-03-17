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
@TableName("ks_class")
@ApiModel(value="Class对象", description="")
public class Class implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = " id", type = IdType.AUTO)
    private Integer  id;

    @ApiModelProperty(value = "专业（班级）")
    private String specialized;

    @ApiModelProperty(value = "学校id")
    private Integer schId;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;


}
