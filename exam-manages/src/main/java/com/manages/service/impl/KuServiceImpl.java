package com.manages.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.api.CommonResult;
import com.manages.service.KuImplService;
import com.mbg.exam.entity.Ku;
import com.mbg.exam.mapper.KuMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuo
 * @since 2022-03-25
 */
@Service
public class KuServiceImpl extends ServiceImpl<KuMapper, Ku> implements KuImplService {



    @Override
    public CommonResult addku(String name, String subject,String tname) {
        Ku ku=new Ku();
        ku.setKuName(name);
        ku.setKuSubject(subject);
        ku.setTeName(tname);
        return CommonResult.success(baseMapper.insert(ku),"题库添加成功");
    }

    @Override
    public CommonResult selectku(int id) {
       return CommonResult.success(baseMapper.selectku(id),"查询成功");
    }

    @Override
    public CommonResult getTopic(int id) {
      return   CommonResult.success(baseMapper.getchooseful1(id),"查询成功");
    }

    @Override
    public CommonResult getTopic2(int id) {
        return   CommonResult.success(baseMapper.getchooseful2(id),"查询成功");
    }


    @Override
    public CommonResult getTopic3(int id) {
        return   CommonResult.success(baseMapper.getchooseful3(id),"查询成功");
    }

    @Override
    public CommonResult getTopic4(int id) {
        return   CommonResult.success(baseMapper.getchooseful4(id),"查询成功");
    }

    @Override
    public CommonResult getTopic5(int id) {
        return   CommonResult.success(baseMapper.getchooseful5(id),"查询成功");
    }

    @Override
    public CommonResult getTopic6(int id) {
        return   CommonResult.success(baseMapper.getchooseful6(id),"查询成功");
    }


    @Override
    public CommonResult getTopic7(int id) {
        return   CommonResult.success(baseMapper.getchooseful7(id),"查询成功");
    }

    @Override
    public CommonResult getTopic8(int id) {
        return   CommonResult.success(baseMapper.getchooseful8(id),"查询成功");
    }

    @Override
    public CommonResult getTopic9(int id) {
        return   CommonResult.success(baseMapper.getchooseful9(id),"查询成功");
    }


    @Override
    public CommonResult getTopic10(int id) {
        return   CommonResult.success(baseMapper.getchooseful10(id),"查询成功");
    }

    @Override
    public CommonResult getTopic11(int id) {
        return   CommonResult.success(baseMapper.getchooseful11(id),"查询成功");
    }

    @Override
    public CommonResult getTopic12(int id) {
        return   CommonResult.success(baseMapper.getchooseful12(id),"查询成功");
    }

    @Override
    public CommonResult getTopic13(int id) {
        return   CommonResult.success(baseMapper.getchooseful13(id),"查询成功");
    }

    @Override
    public CommonResult getTopic14(int id) {
        return   CommonResult.success(baseMapper.getchooseful14(id),"查询成功");
    }
}
