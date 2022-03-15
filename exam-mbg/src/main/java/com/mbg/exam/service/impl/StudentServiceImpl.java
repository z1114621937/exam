//package com.mbg.exam.service.impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.common.api.CommonResult;
//import com.mbg.exam.entity.Student;
//import com.mbg.exam.mapper.StudentMapper;
//import com.mbg.exam.service.StudentImplService;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * <p>
// *  服务实现类
// * </p>
// *
// * @author zuo
// * @since 2022-03-14
// */
//@Service
//public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentImplService {
//
//
//
//
//    @Override
//    public CommonResult register(String username, String password) {
////        QueryWrapper<Student> queryWrapper=new QueryWrapper<>();
////        queryWrapper.lambda().eq(Student::getName,username);
////        Student student= baseMapper.selectOne(queryWrapper);
////        if(student!=null){
////            return CommonResult.failed("该用户已经存在");
////        }
////        Student student1=new Student();
////        student1.setUsername(username);
////        student1.setPassword();
//
//
//    }
//}
