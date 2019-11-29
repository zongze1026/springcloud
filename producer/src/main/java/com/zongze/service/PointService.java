package com.zongze.service;

import com.zongze.dao.MqMessageMapper;
import com.zongze.dao.PointMapper;
import com.zongze.entity.MqMessage;
import com.zongze.entity.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create By xzz on 2019/11/28
 */
@Service
public class PointService {

    @Autowired
    private PointMapper pointMapper;
    @Autowired
    private MqMessageMapper mqMessageMapper;

    @Transactional
    public boolean addPoint(MqMessage mqMessage) {
        Point point = new Point();
        point.setPointNum(10);
        point.setId(1);
        mqMessage.setMessageStatus("2");
        boolean r = pointMapper.addPoint(point) > 0 && mqMessageMapper.consumerMessage(mqMessage) > 0;
        return r;
    }


}
