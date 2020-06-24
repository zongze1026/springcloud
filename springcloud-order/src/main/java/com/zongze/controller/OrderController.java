package com.zongze.controller;
import com.zongze.common.Order;
import com.zongze.common.ResultResp;
import com.zongze.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By xzz on 2020/6/24
 */
@RestController
@RequestMapping("order")
public class OrderController {


    @Autowired
    private OrderService orderService;


    @PostMapping("create")
    public ResultResp createOrder(@RequestBody Order order){
        order.setPrice("5000");
        return orderService.saveOrder(order);
    }









}
