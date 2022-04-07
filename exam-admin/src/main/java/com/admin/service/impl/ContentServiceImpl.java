package com.admin.service.impl;

import com.admin.service.ContentImplService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Content;
import com.mbg.exam.mapper.ContentMapper;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements ContentImplService {

    private ContentMapper contentMapper;


    //查看公告
    @Override
    public CommonResult getContent() {
        QueryWrapper<Content> wrapper= new QueryWrapper<>();
        List<Content> list= baseMapper.selectList(wrapper);
        if (list.size()<1)
            return CommonResult.failed("没有任何公告");
        return CommonResult.success(list,"公告查看成功");
    }

    @Override
    public CommonResult createContent(String tea_name, String content) {

        Content content1=new Content();
        content1.setTeaName(tea_name);
        content1.setContent(content);
   int result=baseMapper.insert(content1);
  if (result>=1) return CommonResult.success("添加公告成功");
        return CommonResult.failed("添加公告成功");
    }

    }











