package com.manages.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.api.CommonResult;
import com.common.constant.RedisKeyPrefixConst;
import com.manages.service.MingciImplService;
import com.manages.util.RedisOpsUtil;
import com.mbg.exam.entity.FullInput;
import com.mbg.exam.entity.Listen;
import com.mbg.exam.entity.Mingci;
import com.mbg.exam.entity.Yue;
import com.mbg.exam.mapper.MingciMapper;
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
public class MingciServiceImpl extends ServiceImpl<MingciMapper, Mingci> implements MingciImplService {

    @Autowired
    private RedisOpsUtil redisOpsUtil;

    @Override
    public CommonResult updateming(int id, Mingci mingci) {
        Mingci mingci1 = baseMapper.selectById(id);
        mingci1.setId(null);
        redisOpsUtil.set(RedisKeyPrefixConst.KU_MINGCI_CACHE+id,mingci1);
        UpdateWrapper<Mingci> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(Mingci::getId,id);
        return CommonResult.success(baseMapper.update(mingci,updateWrapper),"修改一问一答成功");
    }

    @Override
    public CommonResult delming(int id) {
        Mingci mingci = baseMapper.selectById(id);
        if(mingci==null){
            return CommonResult.failed(201,"对象已删除");
        }
        mingci.setId(null);
        redisOpsUtil.set(RedisKeyPrefixConst.KU_MINGCI_DECACHE+id,mingci);
        return CommonResult.success(baseMapper.deleteById(id),"删除成功");
    }

    @Override
    public CommonResult selectming(int id, int upde) {
        if(upde==1){
            Object o = redisOpsUtil.get(RedisKeyPrefixConst.KU_MINGCI_CACHE + id, Mingci.class);
            System.out.println(o);
            Mingci mingci2=(Mingci) o;
            return CommonResult.success(mingci2);
        }
        else {
            Object o = redisOpsUtil.get(RedisKeyPrefixConst.KU_MINGCI_DECACHE + id, Mingci.class);
            System.out.println(o);
            Mingci mingci2=(Mingci) o;
            return CommonResult.success(mingci2);
        }
    }
}
