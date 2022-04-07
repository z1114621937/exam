package com.mbg.exam.mapper;

import com.mbg.exam.entity.Ku;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zuo
 * @since 2022-04-05
 */
public interface KuMapper extends BaseMapper<Ku> {


    List getchoosefu1(int id);
}
