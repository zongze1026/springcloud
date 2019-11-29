package com.zongze.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.DefaultMessagePropertiesConverter;
import org.springframework.amqp.rabbit.support.MessagePropertiesConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create By xzz on 2019/4/11
 */
@Configuration
public class MQConfig {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    public MqSender mqSender() {
        MqSender mqSender = new MqSender();
        rabbitTemplate.setConfirmCallback(mqSender);
        rabbitTemplate.setReturnCallback(mqSender);
//        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        mqSender.setAmqpTemplate(rabbitTemplate);
        return mqSender;
    }





}
