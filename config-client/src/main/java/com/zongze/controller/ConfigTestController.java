package com.zongze.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By xzz on 2019/10/12
 */
@RestController
public class ConfigTestController {

    @Value("${config.dev.name}")
    String name;

    @GetMapping("config")
    public String getConf() {
        return name;
    }


}
