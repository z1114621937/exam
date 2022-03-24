package com.stu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.api.CommonResult;
import com.common.constant.RedisKeyPrefixConst;
import com.mbg.exam.entity.Paper;
import com.mbg.exam.mapper.PaperMapper;
import com.stu.service.PaperImplService;
import com.stu.util.RedisOpsUtil;
import net.sf.jsqlparser.statement.select.KSQLWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperImplService {



    @Autowired
    private RedisOpsUtil redisOpsUtil;

    @Override
    public CommonResult selectpaper(Integer id) {



        return CommonResult.success(baseMapper.getpaper(id), "查询成功");
    }


    @Override
    public CommonResult selectpaper2(Integer id) {
        Paper paper=null;

        paper=redisOpsUtil.get(RedisKeyPrefixConst.PAPER_STU_CACHE+id,Paper.class);



        if (null!=paper){
            return CommonResult.success(paper,"redis查找成功");
        }

         paper = baseMapper.getpaper2(id);

        redisOpsUtil.set(RedisKeyPrefixConst.PAPER_STU_CACHE+id,paper,3600, TimeUnit.SECONDS);
        return CommonResult.success(paper, "查询成功");
    }

    @Override
    public CommonResult demo(Integer id) {

        return null;
    }

    @Override
    public CommonResult updatestate1(Integer id){
        UpdateWrapper<Paper> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(Paper::getState,id)
                .set(Paper::getState,1);
        return CommonResult.success("更改成功");
    }



    @Override
    public CommonResult updatestate2(Integer id){
        UpdateWrapper<Paper> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(Paper::getState,id)
                .set(Paper::getState,2);
        return CommonResult.success("更改成功");
    }


    @Override
    public CommonResult inquiry(String school, String classes) {
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


        return CommonResult.success(baseMapper.inquiry(school, classes), "查询成功");
    }
}
