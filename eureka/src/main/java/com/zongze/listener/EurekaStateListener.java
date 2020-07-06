package com.zongze.listener;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Date 2020/7/4 21:44
 * @Created by xzz
 */
@Component
public class EurekaStateListener {


    /**
     * 服务下线监听
     * @param event
     * @return void
     */
    @EventListener
    public void listen(EurekaInstanceCanceledEvent event){
        System.out.println("监听到节点下线："+event.getAppName());
    }


    /**
     * 服务注册事件
     * @param event
     * @return void
     */
    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event){
        InstanceInfo instance = event.getInstanceInfo();
        System.out.println("监听到服务注册："+instance.getAppName());
    }



    /**
     * 服务注册中心启动事件
     * @param event
     * @return void
     */
    @EventListener
    public void listen(EurekaRegistryAvailableEvent event){
        System.out.println("服务注册中心启动："+event.toString());
    }


    /**
     * eureka服务启动事件
     * @param event
     * @return void
     */
    @EventListener
    public void listen(EurekaServerStartedEvent event){
        System.out.println("eureka服务启动："+event.toString());
    }








}
