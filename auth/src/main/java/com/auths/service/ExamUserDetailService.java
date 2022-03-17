package com.auths.service;


import com.alibaba.cloud.commons.lang.StringUtils;
import com.auths.domain.MemberDetails;
import com.auths.domain.UmsMember;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mbg.exam.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


/**
 * @author zuo
 */
@Service
@Slf4j
public class ExamUserDetailService implements UserDetailsService {

    @Bean
    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }

    @Autowired
    StudentImplService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // TODO  查数据库获取用户信息   rpc调用
        // 加载用户信息
        if (StringUtils.isEmpty(username)) {
            log.warn("用户登陆用户名为空:{}", username);
            throw new UsernameNotFoundException("用户名不能为空");
        }

        QueryWrapper<Student> queryWrapper =new QueryWrapper<>();
        queryWrapper.lambda().eq(Student::getUsername,username);
        Student student=service.getOne(queryWrapper);

     //   UmsMember umsMember = new UmsMember(1,"admin",passwordEncoder().encode("123456"),1);

        if (null == student) {
            log.warn("根据用户名没有查询到对应的用户信息:{}", username);
        }

        log.info("根据用户名:{}获取用户登陆信息:{}", username, student);

        // 会员信息的封装   必须封装到implements UserDetails
        MemberDetails memberDetails = new MemberDetails(student);

        return memberDetails;
    }


}
