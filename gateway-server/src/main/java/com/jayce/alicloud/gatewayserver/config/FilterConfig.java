package com.jayce.alicloud.gatewayserver.config;

import com.jayce.alicloud.gatewayserver.filter.AfterGatewayFilter;
import com.jayce.alicloud.gatewayserver.filter.PreGlobalFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class FilterConfig {

    @Bean
    public PreGlobalFilter preGlobalFilter() {
        log.info("【FilterConfig】 PreGlobalFilter init....");
        return new PreGlobalFilter();
    }

    @Bean
    public RouteLocator afterGatewayFilter(RouteLocatorBuilder builder) {
        log.info("【AfterGatewayFilter】 AfterGatewayFilter init....");
        return builder.routes()
                .route(r -> r.path("/api/boot/**")
                        .filters(f -> f.stripPrefix(2).filter(new AfterGatewayFilter())
                                .addResponseHeader("X-AfterGatewayFilter", "pass"))
                        .uri("lb://boot-server")
                        .order(0)
                        .id("num1")
                )
                .build();
    }
}
