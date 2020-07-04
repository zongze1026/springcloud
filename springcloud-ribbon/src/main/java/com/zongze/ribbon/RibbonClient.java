package com.zongze.ribbon;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;
import rx.Observable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2020/7/4 22:26
 * @Created by xzz
 */
public class RibbonClient {


    List<Server> servers = new ArrayList<>();
    ILoadBalancer loadBalancer;


    public RibbonClient() {
        servers.add(new Server("localhost", 9070));
        servers.add(new Server("localhost", 9071));
        loadBalancer = LoadBalancerBuilder.newBuilder().buildFixedServerListLoadBalancer(servers);
    }


    public String call() {
        LoadBalancerCommand<String> loadBalancerCommand = LoadBalancerCommand
                .<String>builder()
                .withLoadBalancer(loadBalancer)
                .build();

        String data = loadBalancerCommand.submit(new ServerOperation<String>() {
            @Override
            public Observable<String> call(Server server) {
                StringBuilder buffer = new StringBuilder("http://");
                buffer.append(server.getHost())
                        .append(":")
                        .append(server.getPort())
                        .append("/config");
                System.out.println(buffer.toString());

                return Observable.just(HttpUtil.sendGet(buffer.toString()));
            }
        }).toBlocking().first();

        return data;
    }


}
