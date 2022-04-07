package com.admin.controller;


import com.admin.service.ContentImplService;
import com.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exam/content")
public class ContentController {

    @Autowired
    private ContentImplService contentImplService;

    //发布公告
    @RequestMapping("/getcontent")
    public CommonResult getContent() {
        return contentImplService.getContent();
    }


    //创建公告
    @RequestMapping("/createcontent")
    public CommonResult createContent(@RequestParam String tea_name,
                                      @RequestParam String content) {
        return contentImplService.createContent(tea_name,content);
    }


}
