package com.zongze.common.entity;
import lombok.Data;
import java.util.Date;

/**
 * Create By xzz on 2019/11/28
 */
@Data
public class Order {
    private String id;
    private String orderName;
    private double orderPrice;
    private Date orderTime;
}
