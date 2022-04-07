package com.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Paper;


import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
public interface PaperImplService extends IService<Paper> {

    CommonResult createPaper( Map map);
    CommonResult <List>getTopic( int type,String subject,String level);

    CommonResult <List>viewPaper(int paper_id);

    CommonResult <List> randomPaper(Map map);

    CommonResult <List> addTopic(int type);

    CommonResult   deletePaper(int paper_id);

    CommonResult   createExam( Map map);

    CommonResult  test(String aa);


}
