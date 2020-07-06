package com.zongze.consumer;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.zongze.common.entity.MqMessage;
import com.zongze.common.entity.Order;
import com.zongze.service.OrderService;
import com.zongze.service.PointService;
import com.zongze.service.RabbitmqTransactionService;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Create By xzz on 2019/3/29
 */
@Component
public class OrderConsumer {

    @Autowired
    private PointService pointService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private RabbitmqTransactionService transactionService;


    @RabbitListener(queues = "order_queue")
    public void receive(String content, Channel channel, Message message) throws IOException {
        //当前消息的id
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            System.out.println(deliveryTag);
            MqMessage mqMessage = JSON.parseObject(content, MqMessage.class);
            Order order = orderService.findOrder(mqMessage.getId());
            mqMessage = transactionService.findTransactionMessage(mqMessage.getId());
            if (mqMessage != null && order != null) {
                if (StringUtils.equalsIgnoreCase(mqMessage.getMessageStatus(), "2")) {
                    channel.basicAck(deliveryTag, false);
                    return;
                }
                if (pointService.addPoint(mqMessage)) {
                    //手动应答ack，第二个参数：true:会把小于当前id的消息全部ack掉 false:只ack当前消息
                    channel.basicAck(deliveryTag, false);
                } else {
                    channel.basicNack(deliveryTag, false, false);
                    //TODO 记录错误信息到数据库，人工处理
                }
            }
            //如果业务逻辑处理失败的话有两种方案：
            // 1.重新入队,需要注意的是如果业务逻辑抛出异常可能程序会陷入死循环
            // 2.不重新入队，记录消息消费失败到数据库；人工处理
        } catch (Exception e) {
            e.printStackTrace();
            channel.basicNack(deliveryTag, false, false);
            //TODO 记录错误信息到数据库，人工处理
        }
    }


}
