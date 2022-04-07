package com.manages.controller;


import com.common.api.CommonResult;
import com.manages.service.KuImplService;
import com.manages.service.StudentImplService;
import com.mbg.exam.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class KuController {

    @Autowired
    private KuImplService kuImplService;


    @Autowired
    StudentImplService studentImplService;
    //单选
    @RequestMapping("/gettopic1")
    public CommonResult getTopic(@RequestParam Integer tiku_id)
    {

        return kuImplService.getTopic(tiku_id);
    }

    //多选
    @RequestMapping("/gettopic2")
    public CommonResult getTopic2(@RequestParam Integer tiku_id)
    {
        /*Student student = studentImplService.getById(mid);
        String teachername=student.getName();*/
        return kuImplService.getTopic2(tiku_id);
    }

   //填空
    @RequestMapping("/gettopic3")
    public CommonResult getTopic3(@RequestParam Integer tiku_id)
    {
       return kuImplService.getTopic3(tiku_id);
    }

    //判断
    @RequestMapping("/gettopic4")
    public CommonResult getTopic4(@RequestParam Integer tiku_id)
    {
        return kuImplService.getTopic4(tiku_id);
    }


    //分录
    @RequestMapping("/gettopic5")
    public CommonResult getTopic5(@RequestParam Integer tiku_id)
    {
        return kuImplService.getTopic5(tiku_id);
    }

    //资料
    @RequestMapping("/gettopic6")
    public CommonResult getTopic6(@RequestParam Integer tiku_id)
    {
        return kuImplService.getTopic6(tiku_id);
    }

    //完型填空
    @RequestMapping("/gettopic7")
    public CommonResult getTopic7(@RequestParam Integer tiku_id)
    {
        return kuImplService.getTopic7(tiku_id);
    }

    //听力
    @RequestMapping("/gettopic8")
    public CommonResult getTopic8(@RequestParam Integer tiku_id)
    {
        return kuImplService.getTopic8(tiku_id);
    }

    //名词解析
    @RequestMapping("/gettopic9")
    public CommonResult getTopic9(@RequestParam Integer tiku_id)
    {
        return kuImplService.getTopic9(tiku_id);
    }

    //论述
    @RequestMapping("/gettopic10")
    public CommonResult getTopic10(@RequestParam Integer tiku_id)
    {
        return kuImplService.getTopic10(tiku_id);
    }

    //计算
    @RequestMapping("/gettopic11")
    public CommonResult getTopic11(@RequestParam Integer tiku_id)
    {
        return kuImplService.getTopic11(tiku_id);
    }

    //简答
    @RequestMapping("/gettopic12")
    public CommonResult getTopic12(@RequestParam Integer tiku_id)
    {
        return kuImplService.getTopic12(tiku_id);
    }

    //口语
    @RequestMapping("/gettopic13")
    public CommonResult getTopic13(@RequestParam Integer tiku_id)
    {
        return kuImplService.getTopic13(tiku_id);
    }

    //阅读理解
    @RequestMapping("/gettopic14")
    public CommonResult getTopic14(@RequestParam Integer tiku_id)
    {
        return kuImplService.getTopic14(tiku_id);
    }






}
