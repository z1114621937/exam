package com.sup.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Student;
import com.mbg.exam.mapper.StudentMapper;

import com.sup.service.StudentImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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




    @Autowired
    StudentMapper studentMapper;

    @Override
    public IPage<Map> selectguan() {
        Page<Map> page=new Page<Map>(1,2);

        return   studentMapper.selectguan(page);
    }


    @Override
    public CommonResult permissions(int id) {
        UpdateWrapper<Student> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(Student::getId,id)
                .set(Student::getStateDe,0);
        Student student=new Student();

        return CommonResult.success( baseMapper.update(student,updateWrapper),"开启管理员权限成功");
    }

    @Override
    public CommonResult nopermissions(int id) {
        IPage<Student> iPage=new Page<>(1,2);
        UpdateWrapper<Student> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(Student::getId,id)
                .set(Student::getStateDe,1);
        Student student=new Student();

        return CommonResult.success( baseMapper.update(student,updateWrapper),"禁止管理员权限成功");
    }


}
