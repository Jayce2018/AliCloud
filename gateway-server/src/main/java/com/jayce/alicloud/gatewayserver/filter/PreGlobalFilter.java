package com.jayce.alicloud.gatewayserver.filter;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Slf4j
public class PreGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //全局请求参数
        ServerHttpRequest req = exchange.getRequest();
        String path = req.getURI().getPath();
        MultiValueMap<String, String> params = req.getQueryParams();
        log.info("【PreGlobalFilter】请求路径："+path);
        log.info("【PreGlobalFilter】请求参数："+ JSONObject.toJSON(params));
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
