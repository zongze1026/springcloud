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


    public CommonCorrelationData(String id, Object messageBody, String exchange, String routKey) {
        super(id);
        this.messageBody = messageBody;
        this.exchange = exchange;
        this.routKey = routKey;
    }
}
