package com.manages.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.api.CommonResult;
import com.common.constant.RedisKeyPrefixConst;
import com.manages.service.ListenImplService;
import com.manages.util.RedisOpsUtil;
import com.mbg.exam.entity.Choose;
import com.mbg.exam.entity.FullInput;
import com.mbg.exam.entity.Listen;
import com.mbg.exam.entity.Mingci;
import com.mbg.exam.mapper.ListenMapper;
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
public class ListenServiceImpl extends ServiceImpl<ListenMapper, Listen> implements ListenImplService {

    @Autowired
    private RedisOpsUtil redisOpsUtil;
    @Override
    public CommonResult updatelisten(int id, Listen listen) {
        Listen listen1 = baseMapper.selectById(id);
        listen1.setId(null);
        redisOpsUtil.set(RedisKeyPrefixConst.KU_LISTEN_CACHE+id,listen1);
        UpdateWrapper<Listen> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(Listen::getId,id);
        return CommonResult.success(baseMapper.update(listen,updateWrapper),"选择题修改成功");
    }

    @Override
    public CommonResult dellisten(int id) {
        Listen listen = baseMapper.selectById(id);
        if(listen==null){
            return CommonResult.failed(201,"对象已删除");
        }
        listen.setId(null);
        redisOpsUtil.set(RedisKeyPrefixConst.KU_LISTEN_DECACHE+id,listen);
        return CommonResult.success(baseMapper.deleteById(id),"删除成功");
    }

    @Override
    public CommonResult selectlisten(int id, int upde) {
        if(upde==1){
            Object o = redisOpsUtil.get(RedisKeyPrefixConst.KU_LISTEN_CACHE + id, Listen.class);
            System.out.println(o);
            Listen listen=(Listen) o;
            return CommonResult.success(listen);
        }
        else {
            Object o = redisOpsUtil.get(RedisKeyPrefixConst.KU_LISTEN_DECACHE + id, Listen.class);
            System.out.println(o);
            Listen listen=(Listen) o;
            return CommonResult.success(listen);
        }
    }
}
