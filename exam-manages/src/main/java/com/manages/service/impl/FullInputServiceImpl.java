package com.manages.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.api.CommonResult;
import com.common.constant.RedisKeyPrefixConst;
import com.manages.service.FullInputImplService;
import com.manages.util.RedisOpsUtil;
import com.mbg.exam.entity.Fill;
import com.mbg.exam.entity.FullInput;
import com.mbg.exam.entity.Listen;
import com.mbg.exam.mapper.FullInputMapper;
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
public class FullInputServiceImpl extends ServiceImpl<FullInputMapper, FullInput> implements FullInputImplService {

    @Autowired
    private RedisOpsUtil redisOpsUtil;
    @Override
    public CommonResult updatefull(int id, FullInput fullInput) {

        FullInput fullInput1 = baseMapper.selectById(id);
        fullInput1.setId(null);
        redisOpsUtil.set(RedisKeyPrefixConst.KU_FULL_CACHE+id,fullInput1);
        UpdateWrapper<FullInput> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(FullInput::getId,id);
        return CommonResult.success(baseMapper.update(fullInput,updateWrapper),"修改一问一答成功");
    }

    @Override
    public CommonResult delfull(int id) {
        FullInput fullInput = baseMapper.selectById(id);
        if(fullInput==null){
            return CommonResult.failed(201,"对象已删除");
        }
        fullInput.setId(null);
        redisOpsUtil.set(RedisKeyPrefixConst.KU_FULL_DECACHE+id,fullInput);
        return CommonResult.success(baseMapper.deleteById(id),"删除成功");
    }

    @Override
    public CommonResult selectfull(int id, int upde) {
        if(upde==1){
            Object o = redisOpsUtil.get(RedisKeyPrefixConst.KU_FULL_CACHE + id, FullInput.class);
            FullInput fullInput=(FullInput) o;
            return CommonResult.success(fullInput);
        }
        else {
            Object o = redisOpsUtil.get(RedisKeyPrefixConst.KU_FULL_DECACHE + id, FullInput.class);
            FullInput fullInput=(FullInput) o;
            return CommonResult.success(fullInput);
        }
    }
}
