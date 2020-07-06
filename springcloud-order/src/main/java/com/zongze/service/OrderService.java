package com.zongze.service;
import com.zongze.common.entity.model.Order;
import com.zongze.common.entity.ResultResp;
import com.zongze.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create By xzz on 2020/6/24
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    public ResultResp saveOrder(Order order) {
        orderMapper.addOrder(order);
        return ResultResp.succ(order);
    }
}
