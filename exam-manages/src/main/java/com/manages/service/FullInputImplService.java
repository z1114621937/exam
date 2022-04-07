package com.manages.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Fen;
import com.mbg.exam.entity.FullInput;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
public interface FullInputImplService extends IService<FullInput> {

    CommonResult updatefull(int id, FullInput fullInput);

    CommonResult delfull(int id);

    CommonResult selectfull(int id,int upde);
}
