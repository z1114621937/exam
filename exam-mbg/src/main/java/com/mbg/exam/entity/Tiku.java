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
@TableName("ks_tiku")
@ApiModel(value="Tiku对象", description="")
public class Tiku implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "题库名字")
    private String kName;

    @ApiModelProperty(value = "老师名字")
    private String tName;

    @ApiModelProperty(value = "科目")
    private String kSubject;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private Integer stateDe;


}
