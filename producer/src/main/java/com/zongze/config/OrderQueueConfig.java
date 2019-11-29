package com.zongze.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create By xzz on 2019/11/28
 */
@Configuration
public class OrderQueueConfig {

    public static String orderExchange = "order_exchange";
    public static String orderQueue = "order_queue";

    @Bean
    public Queue orderQueue() {
        return new Queue(orderQueue, true);
    }


    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(orderExchange);
    }


    @Bean
    public Binding bindingOrderQueue() {
        return BindingBuilder.bind(orderQueue()).to(fanoutExchange());
    }



}
