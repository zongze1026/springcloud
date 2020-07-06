package com.zongze.service;

import com.zongze.dao.OrderMapper;
import com.zongze.common.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create By xzz on 2019/11/28
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;


    public int addOrder(Order order) {
        return orderMapper.orderAdd(order);
    }

    public Order findOrder(String orderId){
        return orderMapper.orderFind(orderId);
    }




}
