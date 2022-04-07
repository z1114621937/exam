package com.manages.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manages.service.StudentImplService;
import com.mbg.exam.entity.Student;
import com.mbg.exam.mapper.StudentMapper;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentImplService {

}
