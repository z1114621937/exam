package com.mbg.exam.service;

import com.common.api.CommonResult;
import com.mbg.exam.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuo
 * @since 2022-03-14
 */
public interface StudentImplService extends IService<Student> {

    CommonResult register(String username,String password);
}
