package com.stu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Paper;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
public interface PaperImplService extends IService<Paper> {
    CommonResult selectpaper(Integer id);

    CommonResult selectpaper2(Integer id);

    CommonResult demo(Integer id);

    CommonResult updatestate1(Integer id);

    CommonResult updatestate2(Integer id);

    CommonResult inquiry(String school,String classes);
}
