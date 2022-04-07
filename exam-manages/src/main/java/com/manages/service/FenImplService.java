package com.manages.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Choose;
import com.mbg.exam.entity.Fen;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
public interface FenImplService extends IService<Fen> {

    CommonResult updatefen(int id, Fen fen);

    CommonResult delfen(int id);

    CommonResult selectfen(int id,int upde);
}
