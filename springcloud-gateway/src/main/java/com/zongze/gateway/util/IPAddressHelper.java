package com.zongze.gateway.util;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import java.util.List;


public class IPAddressHelper {

    public static String getClientIP(ServerHttpRequest request) {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
        String ip = "127.0.0.1";
        HttpHeaders headers = request.getHeaders();
        if (null != headers) {
            List<String> ips = headers.get("X-Forwarded-For");
            if (null != ips && ips.size() > 0) {
                ip = ips.get(0);
            }
        }
        return ip;
    }
}
