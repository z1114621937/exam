package com.mbg.exam.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

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
@TableName("ks_logs")
@ApiModel(value="Logs对象", description="")
public class Logs implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "ip地址")
    private String ip;

    @ApiModelProperty(value = "ip地理位子")
    private String ipAddress;

    @ApiModelProperty(value = "日志明细")
    private String data;
    // 创建时间：希望在添加数据的时候填充：当前时间
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    // 修改时间：希望在添加数据、修改数据的时候填充：当前时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyDate;

    @ApiModelProperty(value = "修改人")
    private String teaName;

    private String times;


}
