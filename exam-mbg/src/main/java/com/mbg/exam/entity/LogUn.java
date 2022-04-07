package com.mbg.exam.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2022-03-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ks_log_un")
@ApiModel(value="LogUn对象", description="")
public class LogUn implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "ip地址")
    private String teaIp;

    @ApiModelProperty(value = "操作")
    private String operate;

    @ApiModelProperty(value = "账号id")
    private Integer teaId;

    private LocalDateTime createTime;

    private LocalDateTime modifyDate;

    private Integer cId;

    private Integer fId;

    private Integer fiId;

    private Integer fuId;

    private Integer lisId;

    private Integer minId;

    private Integer yuId;

    private Integer stateDe;

    private Integer upde;

    private Integer unId;

    @TableField(exist = false)
    private String name;
}
