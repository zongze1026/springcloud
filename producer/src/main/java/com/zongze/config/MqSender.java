package com.zongze.config;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * Create By xzz on 2019/3/30
 */
public class MqSender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    private RabbitTemplate amqpTemplate;
    private static Logger logger = LoggerFactory.getLogger(MqSender.class);


    public String send(String exchange, String routKey, Object object, String messageId) {
        amqpTemplate.convertAndSend(exchange, routKey, JSON.toJSONString(object), new CommonCorrelationData(messageId, object, exchange, routKey));
        return "success";
    }


    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (!ack) {
            CommonCorrelationData commonCorrelationData = (CommonCorrelationData) correlationData;
            logger.info("消息发送失败重新发送，params:{}", JSON.toJSONString(commonCorrelationData));
            send(commonCorrelationData.getExchange(), commonCorrelationData.getRoutKey(), commonCorrelationData.getMessageBody(), commonCorrelationData.getId());
        } else {
            logger.info("==============消息发送成功==========");
        }
    }


    /**
     * 交换机没有成功发送到队列有回调
     */
    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        logger.info("message:[{}] i={};s={};s1={};s2={}", message.toString(), i, s, s1, s2);
    }

    public void setAmqpTemplate(RabbitTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

}
