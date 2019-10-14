package com.zongze.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By xzz on 2019/10/12
 */
@RestController
@RefreshScope  //如果需要刷新配置，就需要该注解
public class ConfigTestController {

    @Value("${config.dev.name}")
    String name;

    @GetMapping("config")
    public String getConf() {
        return name;
    }


}
