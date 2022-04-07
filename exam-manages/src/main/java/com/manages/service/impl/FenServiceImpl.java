package com.manages.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.api.CommonResult;
import com.common.constant.RedisKeyPrefixConst;
import com.manages.service.FenImplService;
import com.manages.util.RedisOpsUtil;
import com.mbg.exam.entity.Choose;
import com.mbg.exam.entity.Fen;
import com.mbg.exam.entity.Fill;
import com.mbg.exam.mapper.FenMapper;
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
public class FenServiceImpl extends ServiceImpl<FenMapper, Fen> implements FenImplService {


    @Autowired
    private RedisOpsUtil redisOpsUtil;

    @Override
    public CommonResult updatefen(int id, Fen fen) {
        Fen fen1 = baseMapper.selectById(id);
        fen1.setId(null);
        redisOpsUtil.set(RedisKeyPrefixConst.KU_FEN_CACHE+id,fen1);
        UpdateWrapper<Fen> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(Fen::getId,id);
        return CommonResult.success(baseMapper.update(fen,updateWrapper),"修改一问多答成功");
    }

    @Override
    public CommonResult delfen(int id) {
        Fen fen = baseMapper.selectById(id);
        if(fen==null){
            return CommonResult.failed(201,"对象已删除");
        }
        fen.setId(null);
        redisOpsUtil.set(RedisKeyPrefixConst.KU_FEN_DECACHE+id,fen);
        return CommonResult.success(baseMapper.deleteById(id),"删除成功");
    }

    @Override
    public CommonResult selectfen(int id, int upde) {
        if(upde==1){
            Object o = redisOpsUtil.get(RedisKeyPrefixConst.KU_FEN_CACHE + id, Fen.class);

            return CommonResult.success(o);
        }
        else {
            Object o = redisOpsUtil.get(RedisKeyPrefixConst.KU_FILL_DECACHE + id, Fen.class);

            return CommonResult.success(o);
        }
    }
}
