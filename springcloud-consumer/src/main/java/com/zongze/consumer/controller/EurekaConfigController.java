package com.zongze.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * 通过eurekaClient获取客户端配置
 * @Date 2020/7/4 20:47
 * @Created by xzz
 */
@RestController
public class EurekaConfigController {

    @Autowired
    private EurekaClient eurekaClient;
    @Value("${spring.application.name}")
    private String serverName;

    @GetMapping("config")
    public String getConfig(){
        System.out.println(serverName);
        List<InstanceInfo> infoList = eurekaClient.getInstancesByVipAddress(serverName, false);
        String jsonData = JSON.toJSONString(infoList);
        System.out.println(jsonData);
        return jsonData;
    }


}
