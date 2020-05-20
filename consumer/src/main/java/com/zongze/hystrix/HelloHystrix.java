package com.zongze.hystrix;

import com.zongze.facade.ProducerFacade;
import org.springframework.stereotype.Component;

/**
 * Create By xzz on 2019/1/18
 */
@Component
public class HelloHystrix implements ProducerFacade {

    @Override
    public String hello() {
        return "服务器出现故障;两分钟内不要再次访问！";
    }
}
