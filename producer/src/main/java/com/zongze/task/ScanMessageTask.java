package com.zongze.task;

import com.zongze.entity.MqMessage;
import com.zongze.service.RabbitmqTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Create By xzz on 2019/11/29
 */
@Component
public class ScanMessageTask {

    @Autowired
    private RabbitmqTransactionService service;

    @Scheduled(cron = "0 0/5 * * * ? ") //每天5分钟执行一次
    public void scan() {
        List<MqMessage> list = service.unSendTask();
        if (list != null && list.size() > 0) {
            list.stream().forEach(message -> service.send(message));
        }
    }


}
