package com.zongze.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2020/7/12 20:11
 * @Created by xzz
 */
@RestController
public class HystrixFallbackErrorController {

    @GetMapping("fallback")
    public String fallback(){
        return "服务器正在开小差";
    }



}
