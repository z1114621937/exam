package com.manages.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Fen;
import com.mbg.exam.entity.Fill;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
public interface FillImplService extends IService<Fill> {

    CommonResult updatefill(int id, Fill fill);

    CommonResult delfill(int id);

    CommonResult selectfill(int id,int upde);
}
