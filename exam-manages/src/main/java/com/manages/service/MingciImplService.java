package com.manages.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Listen;
import com.mbg.exam.entity.Mingci;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
public interface MingciImplService extends IService<Mingci> {

    CommonResult updateming(int id, Mingci mingci);

    CommonResult delming(int id);

    CommonResult selectming(int id,int upde);
}
