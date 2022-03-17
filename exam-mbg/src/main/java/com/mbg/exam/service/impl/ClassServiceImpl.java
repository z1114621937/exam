package com.mbg.exam.service.impl;

import com.mbg.exam.entity.Class;
import com.mbg.exam.mapper.ClassMapper;
import com.mbg.exam.service.ClassImplService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuo
 * @since 2022-03-17
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassImplService {

}
