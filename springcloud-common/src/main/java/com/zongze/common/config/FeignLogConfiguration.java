package com.zongze.common.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

//该类不需要添加@configuration注解；避免spring重复扫描
public class FeignLogConfiguration {

  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.BASIC;
  }

}