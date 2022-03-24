package com.sup.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Logs;
import com.mbg.exam.entity.Student;
import com.mbg.exam.mapper.LogsMapper;

import com.sup.service.LogsImplService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
@Service
public class LogsServiceImpl extends ServiceImpl<LogsMapper, Logs> implements LogsImplService {


    /**
     * 增加超级管理员的log日志
     * @param time
     * @param name
     * @param ip
     * @param address
     * @param date
     * @return
     */
    @Override
    public CommonResult insertip(String time, String name, String ip, String address, String date) {
        Logs logs=new Logs();
        logs.setIp(ip);
        logs.setTeaName(name);
        logs.setIpAddress(address);
        logs.setData(date);
        logs.setTimes(time);


        return CommonResult.success(baseMapper.insert(logs));
    }


    /**
     * 查询管理员的登录信息
     * @return
     */
    @Override
    public IPage<Map> selectlog() {
        Page<Map> page=new Page<Map>(1,4);

        return   baseMapper.selectall(page);
    }
}
