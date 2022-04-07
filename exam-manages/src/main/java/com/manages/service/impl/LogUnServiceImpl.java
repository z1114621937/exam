package com.manages.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.common.api.CommonResult;
import com.manages.service.LogUnImplService;
import com.mbg.exam.entity.LogUn;
import com.mbg.exam.mapper.LogUnMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuo
 * @since 2022-03-29
 */
@Service
public class LogUnServiceImpl extends ServiceImpl<LogUnMapper, LogUn> implements LogUnImplService {

    @Override
    public CommonResult selectlog() {

        return CommonResult.success(baseMapper.selectlog(),"查询成功") ;
    }
}
