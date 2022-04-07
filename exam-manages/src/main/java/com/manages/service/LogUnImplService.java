package com.manages.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.api.CommonResult;
import com.mbg.exam.entity.LogUn;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuo
 * @since 2022-03-29
 */
public interface LogUnImplService extends IService<LogUn> {

    CommonResult selectlog();
}
