package com.manages.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Choose;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
public interface ChooseImplService extends IService<Choose> {

    CommonResult updatech(int id,Choose choose,int mid,String ip);

    CommonResult delch(int id);

    CommonResult selectch(int id,int upde);
}
