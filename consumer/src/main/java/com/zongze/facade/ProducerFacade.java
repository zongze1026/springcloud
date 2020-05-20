package com.zongze.facade;

import com.zongze.hystrix.HelloHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create By xzz on 2019/1/18
 */
@FeignClient(value = "producer", fallback = HelloHystrix.class)
public interface ProducerFacade {

    @RequestMapping("hello")
    String hello();


}
