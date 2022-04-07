package com.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Student;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuo
 * @since 2022-03-14
 */
public interface StudentImplService extends IService<Student> {




    /**
     * 查询所有学生
     */
    CommonResult queryStudentList();

    /**
     * 根据账号(username)   删除一个学生
     */

    CommonResult deleteStudent(String username);

    /**
     * 根据账号(username)   查看一个学生
     */

    CommonResult selectStudentByUsername(String username);


    /**
     * 根据账号(username)   增加学生
     */
    CommonResult addStudent(String name,String username,String password,String school,String classes);



    CommonResult writePaper(Map map);


    CommonResult <List>studentPaper(int paper_id,int stu_id);



}
