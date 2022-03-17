package com.stu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mbg.exam.entity.SuperAdmin;
import com.mbg.exam.mapper.SuperAdminMapper;
import com.stu.service.SuperAdminImplService;
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
public class SuperAdminServiceImpl extends ServiceImpl<SuperAdminMapper, SuperAdmin> implements SuperAdminImplService {

}
