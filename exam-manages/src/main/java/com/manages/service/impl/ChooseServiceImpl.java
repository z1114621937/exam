package com.manages.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.api.CommonResult;
import com.common.constant.RedisKeyPrefixConst;
import com.manages.service.ChooseImplService;
import com.manages.util.RedisOpsUtil;
import com.mbg.exam.entity.Choose;
import com.mbg.exam.entity.Fen;
import com.mbg.exam.entity.LogUn;
import com.mbg.exam.mapper.ChooseMapper;

import com.mbg.exam.mapper.LogUnMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
@Service
public class ChooseServiceImpl extends ServiceImpl<ChooseMapper, Choose> implements ChooseImplService {



    @Autowired
    LogUnMapper logUnMapper;
    @Autowired
    private RedisOpsUtil redisOpsUtil;

    @Override
    public CommonResult updatech(int id,Choose choose,int mid,String ip) {
        Choose choose1 = baseMapper.selectById(id);

        choose1.setId(null);
        redisOpsUtil.set(RedisKeyPrefixConst.KU_CHOOSE_CACHE+id,choose1);
        UpdateWrapper<Choose> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(Choose::getId,id);
        return CommonResult.success(baseMapper.update(choose,updateWrapper),"选择题修改成功");
    }

    @Override
    public CommonResult delch(int id) {
        Choose choose = baseMapper.selectById(id);
        if(choose==null){
            return CommonResult.failed(201,"对象已删除");
        }
        choose.setId(null);
        redisOpsUtil.set(RedisKeyPrefixConst.KU_CHOOSE_DECACHE+id,choose);


        return CommonResult.success(baseMapper.deleteById(id),"删除成功");
    }

    @Override
    public CommonResult selectch(int id, int upde) {
        if(upde==1){
            Object o = redisOpsUtil.get(RedisKeyPrefixConst.KU_CHOOSE_CACHE + id, Choose.class);
            Choose choose=(Choose) o;
            return CommonResult.success(choose);
        }
        else {
            Object o = redisOpsUtil.get(RedisKeyPrefixConst.KU_CHOOSE_DECACHE + id, Choose.class);
            Choose choose=(Choose) o;
            return CommonResult.success(choose);
        }
    }
}
