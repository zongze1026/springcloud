package com.zongze.controller;

import com.zongze.facade.ProducerFacade;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Create By xzz on 2019/1/18
 */
@RestController
public class CloudConsumerController {

    @Autowired
    private ProducerFacade facade;

    @RequestMapping("call")
    public String consumer(HttpServletRequest request) {
        boolean hasToken = false;
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            if (StringUtils.equalsIgnoreCase("token", headerNames.nextElement())) {
                hasToken = true;
            }
        }
        if (hasToken) {
            System.out.println(request.getHeader("token"));
        } else {
            System.out.println("请求中没有携带token");
        }
        return facade.hello();
    }


}
