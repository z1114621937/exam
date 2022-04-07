package com.manages.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Fen;
import com.mbg.exam.entity.Listen;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
public interface ListenImplService extends IService<Listen> {

    CommonResult updatelisten(int id, Listen listen);

    CommonResult dellisten(int id);

    CommonResult selectlisten(int id,int upde);
}
