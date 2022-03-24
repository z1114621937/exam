package com.stu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.api.CommonResult;
import com.mbg.exam.entity.ClassPaper;
import org.apache.ibatis.annotations.ResultMap;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
public interface ClassPaperImplService extends IService<ClassPaper> {


    CommonResult inquiry(String school,String classes,String stuNum);

}
