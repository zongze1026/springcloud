package com.zongze.gateway.predicate;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 过滤掉不符合时间区间的请求
 * Create By xzz on 2020/7/9
 */
@Component
public class MyTimeLimitRoutePredicateFactory extends AbstractRoutePredicateFactory<MyTimeLimitRoutePredicateFactory.TimeLimitConfig> {


    public MyTimeLimitRoutePredicateFactory() {
        super(TimeLimitConfig.class);
    }


    @Override
    public Predicate<ServerWebExchange> apply(TimeLimitConfig config) {
        return (webExchange) -> {
            if (config.getEnable()) {
                LocalTime starTime = LocalTime.parse(config.getStarTime());
                LocalTime endTime = LocalTime.parse(config.getEndTime());
                LocalTime now = LocalTime.now();
                return now.isBefore(endTime) && now.isAfter(starTime);
            }
            return true;
        };
    }


    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("starTime", "endTime", "enable");
    }

    public static class TimeLimitConfig {

        private String starTime;
        private String endTime;
        private Boolean enable;

        public Boolean getEnable() {
            return enable;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }

        public String getStarTime() {
            return starTime;
        }

        public void setStarTime(String starTime) {
            this.starTime = starTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }
    }


}
