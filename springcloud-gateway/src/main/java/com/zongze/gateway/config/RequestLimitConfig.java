package com.zongze.gateway.config;

import com.zongze.gateway.util.IPAddressHelper;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.core.publisher.Mono;


/**
 * @Date 2020/7/12 18:00
 * @Created by xzz
 */
@Configuration
public class RequestLimitConfig {


    @Bean
    public KeyResolver ipKeyResolver(){
        return  (exchange)-> Mono.just(IPAddressHelper.getClientIP((ServerHttpRequest) exchange.getRequest()));
    }





}
