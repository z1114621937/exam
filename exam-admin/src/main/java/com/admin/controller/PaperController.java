package com.admin.controller;


import com.admin.service.PaperImplService;
import com.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/exam/paper")
public class PaperController {

    @Autowired
    private PaperImplService paperImplService;

   //通过科目和类型和难度  查看对应种类题目
    @RequestMapping("/getTopic")
    public CommonResult<List> getTopic(@RequestParam int type,
                                 @RequestParam String subject,@RequestParam String level) {
        return paperImplService.getTopic(type,subject,level);
    }

    //手动组卷
    @RequestMapping("/createPaper")
    public CommonResult createPaper(@RequestBody Map map) {
      //  System.out.println((String) map.get("subject"));
        return paperImplService.createPaper(map);
    }


    //预览自己组的试卷
    @RequestMapping("/viewPaper")
    public CommonResult<List> viewPaper(@RequestParam int paper_id) {
        //  System.out.println((String) map.get("subject"));
        return paperImplService.viewPaper(paper_id);
    }


    //随机组卷
    @RequestMapping("/randomPaper")
    public CommonResult<List> randomPaper(@RequestBody Map map) {
        //  System.out.println((String) map.get("subject"));
        return paperImplService.randomPaper(map);
    }

    //删除试卷
    @RequestMapping("/deletePaper")
    public CommonResult deletePaper(@RequestParam int paper_id) {
        //  System.out.println((String) map.get("subject"));
        return paperImplService.deletePaper(paper_id);
    }

    //创建考试
    @RequestMapping("/createExam")
    public CommonResult createExam(@RequestBody Map map) {
        return paperImplService.createExam(map);
    }

}
