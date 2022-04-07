package com.mbg.exam.mapper;


import com.mbg.exam.entity.ClassPaper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
public interface ClassPaperMapper extends BaseMapper<ClassPaper> {

    List<Map<String, Object>> inquiry(@Param("school")String school, @Param("classes")String classes,@Param("stuNum")String stuNum);
}
