package com.admin.controller;


import com.admin.service.ExcelImplService;
import com.admin.service.StudentImplService;
import com.common.api.CommonResult;
import com.netflix.client.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


/**
 * 学生控制器
 * oys
 */

@RestController
@RequestMapping("/exam/student")
public class StuController {
    @Autowired
    private StudentImplService studentImplService;


    @Autowired
    private ExcelImplService excelImplService;



    //查询所有用户
    @GetMapping("/queryStudentList")
    public CommonResult  queryStudentList() {
        return studentImplService.queryStudentList();
    }

    //删除单个学生 通过账号username
    @RequestMapping("/deleteStudent")
    public CommonResult deleteStudent(@RequestParam String username) {
        return studentImplService.deleteStudent(username);
    }

    //查看单个用户 通过账号username
    @RequestMapping("/selectStudentByUsername")
    public CommonResult selectStudentByUsername(@RequestParam String username) {
        return studentImplService.selectStudentByUsername(username);
    }


    //增加学生
    @RequestMapping("/addStudent")
    public CommonResult addStudent(@RequestParam String name,
                                   @RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam String school,
                                   @RequestParam String classes) {
        return studentImplService.addStudent(name, username, password, school, classes);
    }


    //导入excel
    @RequestMapping("/addStudentByExcel")
    public CommonResult addStudentByExcel(@RequestParam("file") MultipartFile file) throws IOException, ClientException {
        return excelImplService.addStudentByExcel(file);
    }


}