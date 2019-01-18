package com.zongze.controller;

import com.zongze.facade.ProducerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By xzz on 2019/1/18
 */
@RestController
public class CloudConsumerController {

    @Autowired
    private ProducerFacade facade;

    @RequestMapping("consumer")
    public String consumer(){
        return facade.hellow();
    }



}
