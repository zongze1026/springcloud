package com.zongze.consumer.facade;

import com.zongze.common.Order;
import com.zongze.common.ResultResp;
import org.springframework.stereotype.Component;

/**
 * Create By xzz on 2020/6/24
 */
@Component
public class OrderHystrix implements OrderFacade {
    @Override
    public ResultResp createOrder(Order order) {
        return ResultResp.fail("订单服务异常");
    }
}
