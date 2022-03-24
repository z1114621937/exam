package com.sup.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Student;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
public interface StudentImplService extends IService<Student> {

    IPage<Map> selectguan();

    CommonResult permissions(int id);

    CommonResult nopermissions(int id);
}
