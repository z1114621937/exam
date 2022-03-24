package com.stu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Student;
import com.mbg.exam.mapper.StudentMapper;
import com.stu.service.StudentImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuo
 * @since 2022-03-14
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentImplService {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public CommonResult register(String username, String password) {
        QueryWrapper<Student> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(Student::getUsername,username);
//        Student student= baseMapper.selectOne(queryWrapper);
//        if(student!=null){
//            return CommonResult.failed("该用户已经存在");
//        }
        List<Student> list=baseMapper.selectList(queryWrapper);

        if(!CollectionUtils.isEmpty(list)){
            return CommonResult.failed("该用户已经存在");
        }
        Student student1=new Student();
        student1.setUsername(username);
        student1.setPassword(passwordEncoder.encode(password));
        baseMapper.insert(student1);
        return CommonResult.success(student1,"注册成功");

    }


//   todo 这里id需要token拿
    @Override
    public CommonResult avatar(String url,int id) {


        Student student=new Student();
        UpdateWrapper<Student> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda()
                .set(Student::getPicture,url)
                .eq(Student::getId,id);
        baseMapper.update(student,updateWrapper);
        return CommonResult.success("头像添加成功");
    }


    //todo   需要id先用数据库有的 比如1 后面加
    @Override
    public CommonResult supplements(String name, String age, String sex, String stu_num, String school, String classes,int id) {
        Student student=new Student();
        UpdateWrapper<Student> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda()
                .set(Student::getName,name)
                .set(Student::getAge,age)
                .set(Student::getSex,sex)
                .set(Student::getStuNum,stu_num)
                .set(Student::getSchool,school)
                .set(Student::getClasses,classes)
                .eq(Student::getId,id);
        baseMapper.update(student,updateWrapper);
        student=baseMapper.selectById(id);
        return CommonResult.success(student,"个人信息添加成功");
    }


}
