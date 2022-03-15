package com.gateway.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * @author zuo
 */
@Configuration
public class RibbonConfig {

    @Autowired
    private LoadBalancerClient loadBalancer;
    @Bean
    // 顺序的问题 SmartInitializingSingleton是在所有的非懒加载单例bean构建完成之后调用的
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(
                Collections.singletonList(
                        new LoadBalancerInterceptor(loadBalancer)));

        return restTemplate;
    }

}
