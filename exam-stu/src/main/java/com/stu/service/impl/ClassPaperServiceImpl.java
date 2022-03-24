package com.stu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.api.CommonResult;
import com.mbg.exam.entity.ClassPaper;
import com.mbg.exam.entity.Paper;
import com.mbg.exam.mapper.ClassPaperMapper;
import com.mbg.exam.mapper.PaperMapper;
import com.stu.service.ClassPaperImplService;
import com.stu.service.PaperImplService;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
@Service
public class ClassPaperServiceImpl extends ServiceImpl<ClassPaperMapper, ClassPaper> implements ClassPaperImplService {






    @Override
    public CommonResult inquiry(String school,String classes,String stuNum) {
//        QueryWrapper<ClassPaper> queryWrapper=new QueryWrapper<>();
//        queryWrapper.lambda().eq(ClassPaper::getSch_paper,school)
//                .eq(ClassPaper::getSpecialized,classes)
//                .select(ClassPaper::getPaperId);
//
//       List list= baseMapper.selectList(queryWrapper);
//        QueryWrapper<Paper> queryWrapper2=new QueryWrapper<>();
//        queryWrapper2.lambda().select(Paper::getScore,Paper::getExamName,Paper::getExamTime,Paper::getState);
//     //   paperMapper.selectList(queryWrapper2).stream().map(paper -> paper.getExamTime()).collect(Collectors.toList());
//
//        return CommonResult.success(paperMapper.selectList(queryWrapper2).stream().map(paper -> { paper.getState(),paper.getExamName()
//        }).collect(Collectors.toList()));
        return CommonResult.success(baseMapper.inquiry(school,classes,stuNum),"查询成功");
    }
}
