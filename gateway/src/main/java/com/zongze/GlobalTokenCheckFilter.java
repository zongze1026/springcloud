package com.zongze;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.util.List;

/**
 * Create By xzz on 2019/10/18
 * 全局过滤器不需要配合配置使用；只需要定义出来交给ioc容器即可
 */
public class GlobalTokenCheckFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        boolean isFilter = false;
        List<String> list = exchange.getRequest().getHeaders().get("token");
        if (null == list || list.size() <= 0) {
            isFilter = true;
        }
        if (isFilter) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        System.out.println("token数量：" + list.size());
        list.stream().forEach(token -> System.out.println(token));

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
