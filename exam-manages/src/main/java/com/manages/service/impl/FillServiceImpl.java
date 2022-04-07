package com.manages.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.api.CommonResult;
import com.common.constant.RedisKeyPrefixConst;
import com.manages.service.FillImplService;
import com.manages.util.RedisOpsUtil;
import com.mbg.exam.entity.Fen;
import com.mbg.exam.entity.Fill;
import com.mbg.exam.entity.FullInput;
import com.mbg.exam.mapper.FillMapper;
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
public class FillServiceImpl extends ServiceImpl<FillMapper, Fill> implements FillImplService {


    @Autowired
    private RedisOpsUtil redisOpsUtil;

    @Override
    public CommonResult updatefill(int id, Fill fill) {

        Fill fill1 = baseMapper.selectById(id);
        fill1.setId(null);
        redisOpsUtil.set(RedisKeyPrefixConst.KU_FILL_CACHE+id,fill1);
        UpdateWrapper<Fill> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(Fill::getId,id);
        return CommonResult.success(baseMapper.update(fill,updateWrapper),"修改一问一答成功");

    }

    @Override
    public CommonResult delfill(int id) {
        Fill fill = baseMapper.selectById(id);
        if(fill==null){
            return CommonResult.failed(201,"对象已删除");
        }
        fill.setId(null);
        redisOpsUtil.set(RedisKeyPrefixConst.KU_FILL_DECACHE+id,fill);
        return CommonResult.success(baseMapper.deleteById(id),"删除成功");
    }

    @Override
    public CommonResult selectfill(int id, int upde) {
        if(upde==1){
            Object o = redisOpsUtil.get(RedisKeyPrefixConst.KU_FILL_CACHE + id, Fill.class);
            Fill fill=(Fill) o;
            return CommonResult.success(fill);
        }
        else {
            Object o = redisOpsUtil.get(RedisKeyPrefixConst.KU_FILL_DECACHE + id, Fill.class);
            Fill fill=(Fill) o;
            return CommonResult.success(fill);
        }
    }
}
