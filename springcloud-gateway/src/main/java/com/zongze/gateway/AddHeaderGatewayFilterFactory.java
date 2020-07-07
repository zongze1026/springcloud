package com.zongze.gateway;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;

/**
 * Create By xzz on 2019/10/18
 */
public class AddHeaderGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {
    @Override
    public GatewayFilter apply(NameValueConfig config) {
        return (exchange,chain)->{
            ServerHttpRequest serverHttpRequest = exchange.getRequest().mutate().header(config.getName(), config.getValue()).build();
            return chain.filter(exchange.mutate().request(serverHttpRequest).build());
        };
    }

    @Override
    public String name() {
        return "AddHeader";
    }
}
