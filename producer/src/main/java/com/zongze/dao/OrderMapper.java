package com.zongze.dao;

import com.zongze.entity.Order;

/**
 * Create By xzz on 2019/11/28
 */
public interface OrderMapper {


    int orderAdd(Order order);

    Order orderFind(String id);



}
