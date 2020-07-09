package com.zongze.gateway.filter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import reactor.core.publisher.Mono;
import java.util.Arrays;
import java.util.List;

/**
 * Create By xzz on 2019/10/17
 */
public class LogGatewayFilterFactory extends AbstractGatewayFilterFactory<LogGatewayFilterFactory.Config> {


    private static final Log log = LogFactory.getLog(LogGatewayFilterFactory.class);
    private static final String START_TIMES = "start";
    private static final String KEY = "simpleLog";

    public LogGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public String name() {
        return "LogGateway";
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            log.info("过滤前");
            exchange.getAttributes().put(START_TIMES, System.currentTimeMillis());
            return chain.filter(exchange).then(
                    Mono.fromRunnable(() -> {
                        Long startTime = exchange.getAttribute(START_TIMES);
                        if (startTime != null) {
                            StringBuilder sb = new StringBuilder(exchange.getRequest().getURI().getRawPath())
                                    .append(": ")
                                    .append(System.currentTimeMillis() - startTime)
                                    .append("ms");
                            if (!config.isWithParams()) {
                                sb.append(" params:").append(exchange.getRequest().getQueryParams());
                            }
                            log.info(sb.toString());
                        }
                    })
            );
        };

    }


    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(KEY);
    }

    public static class Config {

        private boolean simpleLog;

        public boolean isWithParams() {
            return simpleLog;
        }


        public void setWithParams(boolean withParams) {
            this.simpleLog = withParams;
        }

    }


}
