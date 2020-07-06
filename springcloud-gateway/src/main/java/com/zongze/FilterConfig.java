package com.zongze;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create By xzz on 2019/10/18
 */
@Configuration
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
