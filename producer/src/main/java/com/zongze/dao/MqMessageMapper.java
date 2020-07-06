package com.zongze.dao;


import com.zongze.common.entity.MqMessage;

/**
 * Create By xzz on 2019/11/28
 */
public interface MqMessageMapper {


    int addMessage(MqMessage message);

    int consumerMessage(MqMessage message);

    int removeMessage(String id);

    MqMessage findMessage(String messageId);
}
