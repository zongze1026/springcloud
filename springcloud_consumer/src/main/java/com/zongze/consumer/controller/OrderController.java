package com.zongze.consumer.controller;
import com.zongze.common.Order;
import com.zongze.common.ResultResp;
import com.zongze.consumer.facade.OrderFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By xzz on 2020/6/24
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderFacade orderFacade;

    @GetMapping("create")
    public ResultResp createOrder(){
        Order order = new Order();
        order.setGoodsId(1);
        order.setGoodsName("华为手机");
        order.setPrice("2999");
        order.setUserId(1);
        return orderFacade.createOrder(order);
    }



}