package com.admin.controller;

import com.admin.service.StudentImplService;
import com.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/exam")
public class WriteController {

    @Autowired
    private StudentImplService studentImplService;


    //考生写试卷
    @RequestMapping("/writepaper")
    public CommonResult writePaper(@RequestBody Map map) {

        return studentImplService.writePaper(map);
    }


    //成绩详情 查看学生的成绩
    @RequestMapping("/studentpaper")
    public CommonResult <List>studentPaper(@RequestParam int paper_id,
                                           @RequestParam int stu_id) {
        return studentImplService.studentPaper(paper_id,stu_id);
    }






}
