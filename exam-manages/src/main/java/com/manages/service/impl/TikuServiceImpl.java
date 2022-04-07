package com.manages.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.api.CommonResult;

import com.manages.service.TikuImplService;
import com.mbg.exam.entity.Ku;
import com.mbg.exam.entity.Tiku;
import com.mbg.exam.mapper.TikuMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuo
 * @since 2022-03-31
 */
@Service
public class TikuServiceImpl extends ServiceImpl<TikuMapper, Tiku> implements TikuImplService {

    @Override
    public CommonResult addku(String name, String subject,String tname) {
        Tiku ku=new Tiku();
        ku.setKName(name);
        ku.setKSubject(subject);
        ku.setTName(tname);
        return CommonResult.success(baseMapper.insert(ku),"题库添加成功");
    }
}
