package com.mbg.exam.mapper;

import com.mbg.exam.entity.LogUn;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zuo
 * @since 2022-03-29
 */
public interface LogUnMapper extends BaseMapper<LogUn> {
    List<Map<String, Object>> selectlog();
}
