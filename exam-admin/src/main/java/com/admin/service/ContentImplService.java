package com.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.api.CommonResult;
import com.mbg.exam.entity.Content;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
public interface ContentImplService extends IService<Content> {

    CommonResult getContent();

    CommonResult createContent(String tea_name,String content);

}
