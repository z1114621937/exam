package com.mbg.exam.mapper;

import com.common.api.CommonResult;
import com.mbg.exam.entity.Paper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
public interface PaperMapper extends BaseMapper<Paper> {


    List<Paper> getpaper(int id);

    Paper getpaper2(int id);

    List inquiry(@Param("school")String school, @Param("classes")String classes);



}
