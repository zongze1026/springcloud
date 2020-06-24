package com.zongze.consumer.facade;

import com.zongze.common.Order;
import com.zongze.common.ResultResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create By xzz on 2019/1/18
 */
@FeignClient(value = "springcloud-order", fallback = OrderHystrix.class)
public interface OrderFacade {

    @RequestMapping("order/create")
    ResultResp createOrder(@RequestBody Order order);


}
