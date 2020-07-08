package com.zongze.common.facade;

import com.zongze.common.config.FeignLogConfiguration;
import com.zongze.common.hystrix.OrderHystrixFactory;
import com.zongze.common.entity.model.Order;
import com.zongze.common.entity.ResultResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create By xzz on 2019/1/18
 */
@FeignClient(value = "springcloud-order",fallbackFactory = OrderHystrixFactory.class/*,configuration = {FeignLogConfiguration.class}*/)
public interface OrderFacade {

    @RequestMapping("order/create")
    ResultResp createOrder(@RequestBody Order order);


}
