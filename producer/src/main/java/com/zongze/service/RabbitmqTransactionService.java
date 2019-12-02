package com.zongze.service;

import com.zongze.config.MqSender;
import com.zongze.config.OrderQueueConfig;
import com.zongze.dao.MqMessageMapper;
import com.zongze.entity.MqMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By xzz on 2019/11/29
 */
@Service
public class RabbitmqTransactionService {

    @Autowired
    private MqMessageMapper mqMessageMapper;
    @Autowired
    private MqSender mqSender;

    public int addMessage(MqMessage message) {
        return mqMessageMapper.addMessage(message);
    }

    public int delMsg(String messageId) {
        return mqMessageMapper.removeMessage(messageId);
    }

    public MqMessage findTransactionMessage(String messageId) {
        return mqMessageMapper.findMessage(messageId);
    }

    @Transactional
    public void send(MqMessage mqMessage) {
        mqMessage.setMessageStatus("1");
        if (mqMessageMapper.consumerMessage(mqMessage) > 0) {
            mqSender.send(OrderQueueConfig.orderExchange, "", mqMessage);
        }
    }

    public List<MqMessage> unSendMessage() {
        //伪代码
        return new ArrayList<>();
    }
}
