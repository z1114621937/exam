package com.gateway.filter;


import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.fastjson.JSON;

import com.common.api.ResultCode;
import com.common.exception.GateWayException;
import com.gateway.properties.NotAuthUrlProperties;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import com.utils.JwtUtils;

import java.security.PublicKey;
import java.util.Map;

/**
 * @author zuo
 */
@Component
@Order(0)
@EnableConfigurationProperties(value = NotAuthUrlProperties.class)
@Slf4j
public class AuthenticationFilter implements GlobalFilter, InitializingBean {
    
    /**
     * 请求各个微服务 不需要用户认证的URL
     */
    @Autowired
    private NotAuthUrlProperties notAuthUrlProperties;
    
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String currentUrl = exchange.getRequest().getURI().getPath();

        if(shouldSkip(currentUrl)) {
            return chain.filter(exchange);
        }
        

        String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
    

        if(StringUtils.isEmpty(authHeader)) {
            log.warn("需要认证的url,请求头为空");
            throw new GateWayException(ResultCode.AUTHORIZATION_HEADER_IS_EMPTY);
        }
    

        Claims claims = JwtUtils.validateJwtToken(authHeader,publicKey);
    

        ServerWebExchange webExchange = wrapHeader(exchange,claims);
        
        return chain.filter(webExchange);
    }
    
    private ServerWebExchange wrapHeader(ServerWebExchange serverWebExchange,Claims claims) {
        
        String loginUserInfo = JSON.toJSONString(claims);
        
        //log.info("jwt的用户信息:{}",loginUserInfo);
        
        String memberId = claims.get("additionalInfo", Map.class).get("memberId").toString();
        
     //   String nickName = claims.get("additionalInfo",Map.class).get("nickName").toString();
        String school = claims.get("additionalInfo", Map.class).get("school").toString();


        String classes = claims.get("additionalInfo", Map.class).get("classes").toString();

        String stuNum = claims.get("additionalInfo", Map.class).get("stuNum").toString();

        ServerHttpRequest request = serverWebExchange.getRequest().mutate()
//                .header("username",claims.get("user_name",String.class))
                .header("memberId",memberId)
            //    .header("nickName",nickName)
                .header("school",school)

                .header("classes",classes)

                .header("stuNum",stuNum)
                .build();
        

        return serverWebExchange.mutate().request(request).build();
    }
    
    private boolean shouldSkip(String currentUrl) {
        PathMatcher pathMatcher = new AntPathMatcher();
        for(String skipPath:notAuthUrlProperties.getShouldSkipUrls()) {
            if(pathMatcher.match(skipPath,currentUrl)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * jwt的公钥,需要网关启动,远程调用认证中心去获取公钥
     */
    private PublicKey publicKey;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Override
    public void afterPropertiesSet() throws Exception {
        //获取公钥  TODO
        this.publicKey = JwtUtils.genPulicKey(restTemplate);
    }
}
