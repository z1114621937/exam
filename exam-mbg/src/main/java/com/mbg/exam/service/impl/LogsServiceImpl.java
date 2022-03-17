package com.mbg.exam.service.impl;

import com.mbg.exam.entity.Logs;
import com.mbg.exam.mapper.LogsMapper;
import com.mbg.exam.service.LogsImplService;
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
public class LogsServiceImpl extends ServiceImpl<LogsMapper, Logs> implements LogsImplService {

}
