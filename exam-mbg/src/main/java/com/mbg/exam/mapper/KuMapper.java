package com.mbg.exam.mapper;

import com.mbg.exam.entity.Ku;
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
 * @since 2022-03-25
 */
public interface KuMapper extends BaseMapper<Ku> {

    List<Map<String, Object>> selectku(int id);

    List<Map<String, Object>> getchooseful1(int id);

    List<Map<String, Object>> getchooseful2(int id);


    List<Map<String, Object>> getchooseful3(int id);

    List<Map<String, Object>> getchooseful4(int id);

    List<Map<String, Object>> getchooseful5(int id);

    List<Map<String, Object>> getchooseful6(int id);

    List<Map<String, Object>> getchooseful7(int id);

    List<Map<String, Object>> getchooseful8(int id);

    List<Map<String, Object>> getchooseful9(int id);

    List<Map<String, Object>> getchooseful10(int id);

    List<Map<String, Object>> getchooseful11(int id);

    List<Map<String, Object>> getchooseful12(int id);

    List<Map<String, Object>> getchooseful13(int id);

    List<Map<String, Object>> getchooseful14(int id);
}
