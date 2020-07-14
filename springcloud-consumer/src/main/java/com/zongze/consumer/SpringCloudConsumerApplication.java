package com.zongze.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.zongze.common", "com.zongze.consumer"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.zongze.common.facade"}/*, defaultConfiguration = {FeignLogConfiguration.class}*/)
@EnableSwagger2
public class SpringCloudConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerApplication.class, args);
    }

}
