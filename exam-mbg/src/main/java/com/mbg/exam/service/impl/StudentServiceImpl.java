package com.mbg.exam.service.impl;

import com.mbg.exam.entity.Student;
import com.mbg.exam.mapper.StudentMapper;
import com.mbg.exam.service.StudentImplService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuo
 * @since 2022-03-15
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentImplService {

}
