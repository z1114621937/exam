package com.manages.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Mingci;
import com.mbg.exam.entity.Yue;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
public interface YueImplService extends IService<Yue> {

    CommonResult updateyue(int id, Yue yue);

    CommonResult delyue(int id);

    CommonResult selectyue(int id,int upde);
}
