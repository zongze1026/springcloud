package com.zongze.facade;

import com.zongze.hystrix.HellowHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create By xzz on 2019/1/18
 */
@FeignClient(value = "producer", fallback = HellowHystrix.class)
public interface ProducerFacade {

    @RequestMapping("hellow")
    String hellow();


}
