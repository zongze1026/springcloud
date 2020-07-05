package com.zongze.common.hystrix;

import com.zongze.common.facade.OrderFacade;
import com.zongze.entity.ResultResp;
import com.zongze.entity.model.Order;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @Date 2020/7/5 22:18
 * @Created by xzz
 */
@Component
public class OrderHystrixFactory implements FallbackFactory<OrderFacade> {

    private static final Logger logger = LoggerFactory.getLogger(OrderHystrixFactory.class);

    @Override
    public OrderFacade create(Throwable throwable) {
        logger.error("OrderFacade回退，异常：{}",throwable);
        return new OrderFacade() {
            @Override
            public ResultResp createOrder(Order order) {
                return ResultResp.fail("创建订单异常");
            }
        };
    }
}
