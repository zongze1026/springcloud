package com.zongze.consumer.controller;

import com.zongze.common.entity.model.Order;
import com.zongze.common.entity.ResultResp;
import com.zongze.common.facade.OrderFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Create By xzz on 2020/6/24
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderFacade orderFacade;
    @Value("${server.port}")
    private int port;

    @GetMapping("create")
    public ResultResp createOrder(HttpServletRequest request) {
        Order order = new Order();
        order.setGoodsId(1);
        order.setGoodsName("华为手机");
        order.setPrice("2999");
        order.setUserId(1);
        System.out.println("测试修改端口：" + port + ";Token=" + request.getHeader("token"));
        return orderFacade.createOrder(order);
    }


}
