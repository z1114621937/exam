package com.manages.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Tiku;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuo
 * @since 2022-03-31
 */
public interface TikuImplService extends IService<Tiku> {

    CommonResult addku(String name, String subject, String tname);
}
