package com.stu.controller;

import com.common.api.CommonResult;
import com.mbg.exam.entity.Paper;
import com.mbg.exam.entity.Student;
import com.stu.service.ClassPaperImplService;
import com.stu.service.PaperImplService;
import com.stu.service.StudentImplService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/paper")
public class PaperClassController {


    @Autowired
    StudentImplService studentImplService;

    @Autowired
    ClassPaperImplService classPaperImplService;



    @RequestMapping("/inquiry")
    CommonResult CommonResult(@RequestHeader("memberId") Integer id)  {
         Student student=studentImplService.getById(id);

        System.out.println(student);
        return classPaperImplService.inquiry(student.getSchool(),student.getClasses(),student.getStuNum());



    }



}
