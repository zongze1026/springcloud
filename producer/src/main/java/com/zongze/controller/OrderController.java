package com.zongze.controller;

import com.alibaba.fastjson.JSON;
import com.zongze.entity.MqMessage;
import com.zongze.entity.Order;
import com.zongze.service.OrderService;
import com.zongze.service.RabbitmqTransactionService;
import com.zongze.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By xzz on 2019/11/28
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private RabbitmqTransactionService transactionService;


    @GetMapping("add")
    public String orderAdd() {
        String id = String.valueOf(SnowflakeIdWorker.getRandom());
        Order order = new Order();
        order.setId(id);
        order.setOrderName("连衣裙");
        order.setOrderPrice(200);
        //保存消息
        MqMessage mqMessage = new MqMessage();
        mqMessage.setId(id);
        mqMessage.setMessageBody(JSON.toJSONString(order));
        int i = transactionService.addMessage(mqMessage);
        //消息保存成功才执行订单保存
        if (i > 0) {
            if(orderService.addOrder(order)>0){
                //投递消息
                transactionService.send(mqMessage);
            }else{
                //订单保存失败的话就删除消息
                transactionService.delMsg(id);
            }
        }
        return "success";
    }


}
