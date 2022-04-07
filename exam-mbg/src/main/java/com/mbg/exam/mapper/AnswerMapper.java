package com.mbg.exam.mapper;

import com.mbg.exam.entity.Answer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zuo
 * @since 2022-03-31
 */
public interface AnswerMapper extends BaseMapper<Answer> {

   List getpaperandanswer(int paper_id, int stu_id);

}
