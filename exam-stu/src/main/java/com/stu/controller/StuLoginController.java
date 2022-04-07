package com.stu.controller;


import com.common.api.CommonResult;


import com.mbg.exam.entity.Student;
import com.stu.service.PaperImplService;
import com.stu.service.StudentImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
@RequestMapping("/exam")
public class StuLoginController {

    @Autowired
    private StudentImplService student;

    @Autowired
    StudentImplService studentImplService;


    @Autowired
    private PaperImplService paperImplService;


    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/register")
    public CommonResult register(@RequestParam String username,
                                 @RequestParam String password) {
        return student.register(username, password);
    }


    /**
     * 头像上传
     * @param url
     * @param id
     * @return
     */
    @RequestMapping("/avater")
    public CommonResult avater(@RequestParam String url,
                               @RequestHeader("memberId") Integer id) {

        return student.avatar(url,id);
    }


    /**
     * 个人信息添加
     * @param name
     * @param age
     * @param sex
     * @param stu_num
     * @param school
     * @param classes
     * @param id
     * @return
     */
    @RequestMapping("/supplements")
    public CommonResult supplements(@RequestParam String name,
                                    @RequestParam String age,
                                    @RequestParam String sex,
                                    @RequestParam String stu_num,
                                    @RequestParam String school,
                                    @RequestParam String classes,
                                    @RequestHeader("memberId") int id) {
        return student.supplements(name, age, sex, stu_num, school, classes,id);

    }


    /**
     *查找卷子
     * @param id
     * @return
     */
    @RequestMapping("/selectpaper")
    public CommonResult selectpaper(@RequestParam Integer id) {
        return paperImplService.selectpaper2(id);
    }


    @RequestMapping("/demo")
    public String demo(@RequestHeader("school") String school) throws UnsupportedEncodingException {
        String decode = URLDecoder.decode(school, "gb2312");
        return decode;
    }


    @RequestMapping("/inquiry")
    CommonResult CommonResult(@RequestHeader("memberId") Integer id)  {
        Student student=studentImplService.getById(id);

        System.out.println(student);
        return paperImplService.inquiry(student.getSchool(),student.getClasses());

    }




}

