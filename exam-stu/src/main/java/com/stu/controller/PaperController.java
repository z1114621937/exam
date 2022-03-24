package com.stu.controller;

import com.common.api.CommonResult;
import com.mbg.exam.entity.Paper;
import com.stu.service.PaperImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@RestController
@RequestMapping("/papers")
public class PaperController {




    @Autowired
    PaperImplService paperImplService;

    /**
     * 开始考试
     * @param id
     * @return
     * @throws ParseException
     */
    @RequestMapping("/begin")
    CommonResult CommonResult(@RequestParam("id") Integer id) throws ParseException {
//        System.out.println(id);
//        System.out.println(System.currentTimeMillis());
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Paper paper = paperImplService.getById(id);
//        System.out.println(formatter.format(paper.getStartTime()));
//        formatter.format(paper.getStartTime());
//        String format = formatter.format(paper.getStartTime());
//        System.out.println(format);
//        // Data data1= paper.getStartTime();
//        System.out.println(data1);


        LocalDateTime localDateTime = paper.getStartTime();
        LocalDateTime localDateTime2 = paper.getEndTime();
//获取系统默认时区
        ZoneId zoneId = ZoneId.systemDefault();
//时区的日期和时间
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        ZonedDateTime zonedDateTime2 = localDateTime2.atZone(zoneId);
//获取时刻
        Date date = Date.from(zonedDateTime.toInstant());
        Date date2 = Date.from(zonedDateTime2.toInstant());
        System.out.println(date);

        System.out.println(date2);
       // System.out.println("格式化前：localDateTime:" + localDateTime + "  Date:" + date);
//格式化LocalDateTime、Date
        //DateTimeFormatter localDateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        String format2=dateFormat.format(date2);
        System.out.println( new Date().compareTo(date));
        if (new Date().compareTo(date)==1&&new Date().compareTo(date2)==-1){
            return paperImplService.selectpaper2(id) ;
        }
        else{
            return CommonResult.failed("考试还未开始");
        }

    }
}
