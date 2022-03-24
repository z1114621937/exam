package com.stu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Student;

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

    CommonResult avatar(String url,int id);


    CommonResult supplements(String name,String age,String sex,String stu_num,String school,String classes,int id);
}
