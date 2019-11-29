package com.zongze.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Create By xzz on 2019/8/6
 */
@ConfigurationProperties(prefix = "spring.datasource")
@Component
@Data
public class DataSourceProperties {
    private String url;
    private String userName;
    private String passWord;
    private String driverClassName;

}
