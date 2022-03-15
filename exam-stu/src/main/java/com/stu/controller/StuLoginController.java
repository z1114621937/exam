package com.stu.controller;


import com.common.api.CommonResult;


import com.stu.service.StudentImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam")
public class StuLoginController {

    @Autowired
    private StudentImplService student;

    @RequestMapping("/register")
    public CommonResult register(@RequestParam String username,
                                 @RequestParam String password) {
        return student.register(username, password);
    }

    @RequestMapping("/avater")
    public CommonResult avater(@RequestParam String url) {
        return student.avatar(url);
    }


    @RequestMapping("/supplements")
    public CommonResult supplements(@RequestParam String name,
                                    @RequestParam String age,
                                    @RequestParam String sex,
                                    @RequestParam String stu_num,
                                    @RequestParam String school,
                                    @RequestParam String classes) {
        return student.supplements(name, age, sex, stu_num, school, classes);

    }
    }

