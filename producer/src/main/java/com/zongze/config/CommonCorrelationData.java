package com.zongze.config;

import lombok.Data;
import org.springframework.amqp.rabbit.connection.CorrelationData;

/**
 * Create By xzz on 2019/11/28
 */
@Data
public class CommonCorrelationData extends CorrelationData {
    private Object messageBody;
    private String exchange;
    private String routKey;
    private String ttlTime;
    private boolean persistent;


    public CommonCorrelationData(Object messageBody, String exchange, String routKey, String ttlTime, boolean persistent) {
        this.messageBody = messageBody;
        this.exchange = exchange;
        this.routKey = routKey;
        this.ttlTime = ttlTime;
        this.persistent = persistent;
    }
}
