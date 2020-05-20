package com.zongze.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By xzz on 2019/1/18
 */
@RestController
public class HelloCloudController {

    private Logger logger = LoggerFactory.getLogger(HelloCloudController.class);

    @Value("${server.port}")
    private String port;

    @RequestMapping("hello")
    public String hello() {
        String result = "hello springCloud feign ";
        logger.info("result is {}", result + port);
        return result + port;
    }

}
