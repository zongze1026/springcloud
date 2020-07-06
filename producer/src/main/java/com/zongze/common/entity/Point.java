package com.zongze.common.entity;
import lombok.Data;
import java.util.Date;

/**
 * Create By xzz on 2019/11/28
 */
@Data
public class Point {
    private long id;
    private long pointNum;
    private Date addTime;
    private Date updateTime;
}
