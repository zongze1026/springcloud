package com.zongze.controller;
import com.zongze.common.facade.OrderFacade;
import com.zongze.common.entity.model.Order;
import com.zongze.common.entity.ResultResp;
import com.zongze.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By xzz on 2020/6/24
 */
@RestController
@RequestMapping("order")
public class OrderController implements OrderFacade {


    @Autowired
    private OrderService orderService;
    @Value("${server.port}")
    private int port;


    @Override
    @PostMapping("create")
    public ResultResp createOrder( @RequestBody Order order) {
        System.out.println("请求的端口：" + port);
        order.setPrice(port + "");
        return orderService.saveOrder(order);
    }


}
