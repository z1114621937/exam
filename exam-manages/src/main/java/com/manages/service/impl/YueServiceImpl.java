package com.manages.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.api.CommonResult;
import com.common.constant.RedisKeyPrefixConst;
import com.manages.service.YueImplService;
import com.manages.util.RedisOpsUtil;
import com.mbg.exam.entity.Mingci;
import com.mbg.exam.entity.Yue;
import com.mbg.exam.mapper.YueMapper;
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
public class YueServiceImpl extends ServiceImpl<YueMapper, Yue> implements YueImplService {

    @Autowired
    private RedisOpsUtil redisOpsUtil;


    @Override
    public CommonResult updateyue(int id, Yue yue) {
        Yue yue1 = baseMapper.selectById(id);
        yue1.setId(null);
        redisOpsUtil.set(RedisKeyPrefixConst.KU_YUE_CACHE+id,yue1);

        //redis转换对象
//        Object o = redisOpsUtil.get(RedisKeyPrefixConst.KU_YUE_CACHE + id, Yue.class);
//        System.out.println(o);
//        Yue yue2=(Yue) o;
//        baseMapper.insert(yue2);
        UpdateWrapper<Yue> updateWrapper=new UpdateWrapper<>();
        updateWrapper.lambda().eq(Yue::getId,id);
        return CommonResult.success(baseMapper.update(yue,updateWrapper),"修改一问一答成功");
    }

    @Override
    public CommonResult delyue(int id) {
        Yue yue = baseMapper.selectById(id);
        if(yue==null){
            return CommonResult.failed(201,"对象已删除");
        }
        yue.setId(null);
        redisOpsUtil.set(RedisKeyPrefixConst.KU_YUE_DECACHE+id,yue);
        return CommonResult.success(baseMapper.deleteById(id),"删除成功");
    }

    @Override
    public CommonResult selectyue(int id, int upde) {
        if(upde==1){
            Object o = redisOpsUtil.get(RedisKeyPrefixConst.KU_YUE_CACHE + id, Yue.class);
            System.out.println(o);
            Yue yue2=(Yue) o;
            return CommonResult.success(yue2);
        }
        else {
            Object o = redisOpsUtil.get(RedisKeyPrefixConst.KU_YUE_DECACHE + id, Yue.class);
            System.out.println(o);
            Yue yue2=(Yue) o;
            return CommonResult.success(yue2);
        }

    }
}
