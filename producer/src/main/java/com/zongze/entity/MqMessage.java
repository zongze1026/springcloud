package com.zongze.entity;
import lombok.Data;
import java.util.Date;

/**
 * Create By xzz on 2019/11/28
 */
@Data
public class MqMessage {
    private String id;
    private String messageBody;
    private String messageStatus;
    private Date addTime;
    private Date updateTime;
}
