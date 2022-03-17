package com.mbg.exam.service.impl;

import com.mbg.exam.entity.Content;
import com.mbg.exam.mapper.ContentMapper;
import com.mbg.exam.service.ContentImplService;
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
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements ContentImplService {

}
