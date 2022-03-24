package com.sup.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Logs;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
public interface LogsImplService extends IService<Logs> {

    CommonResult insertip(String time,String name,String ip,String address,String date);

    IPage<Map> selectlog();
}
