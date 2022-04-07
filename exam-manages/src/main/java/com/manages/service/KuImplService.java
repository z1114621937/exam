package com.manages.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Ku;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuo
 * @since 2022-03-25
 */
public interface KuImplService extends IService<Ku> {

    CommonResult addku(String name,String subject,String tname);

    CommonResult selectku(int id);

    CommonResult getTopic(int id);

    CommonResult getTopic2(int id);

    CommonResult getTopic3(int id);

    CommonResult getTopic4(int id);

    CommonResult getTopic5(int id);

    CommonResult getTopic6(int id);

    CommonResult getTopic7(int id);

    CommonResult getTopic8(int id);

    CommonResult getTopic9(int id);

    CommonResult getTopic10(int id);

    CommonResult getTopic11(int id);

    CommonResult getTopic12(int id);

    CommonResult getTopic13(int id);

    CommonResult getTopic14(int id);
   // CommonResult<List> getTopic2(int id);
}
