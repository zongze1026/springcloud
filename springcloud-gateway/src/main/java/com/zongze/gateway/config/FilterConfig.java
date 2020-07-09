package com.zongze.gateway.config;
import com.zongze.gateway.filter.AddHeaderGatewayFilterFactory;
import com.zongze.gateway.filter.GlobalTokenCheckFilter;
import com.zongze.gateway.filter.LogGatewayFilterFactory;
import org.springframework.context.annotation.Bean;

/**
 * Create By xzz on 2019/10/18
 */
//@Configuration
public class FilterConfig {


    @Bean
    public LogGatewayFilterFactory logGatewayFilterFactory() {
        return new LogGatewayFilterFactory();
    }

    @Bean
    public AddHeaderGatewayFilterFactory addHeaderGatewayFilterFactory() {
        return new AddHeaderGatewayFilterFactory();
    }

    @Bean
    public GlobalTokenCheckFilter globalTokenCheckFilter() {
        return new GlobalTokenCheckFilter();
    }


}
