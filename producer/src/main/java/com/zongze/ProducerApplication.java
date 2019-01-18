package com.zongze;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @EnableDiscoveryClient(EnableEurekaClient只能使用eureka作为注册中心;EnableDiscoveryClient可以使用其他的注册中心注册)
 * */
@SpringBootApplication
@EnableDiscoveryClient
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

}

