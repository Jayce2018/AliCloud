package com.jayce.alicloud.gatewayserver.filter;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.NettyWriteResponseFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;
import java.util.List;

@Slf4j
public class AfterGatewayFilter implements GatewayFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpResponse originalResponse = exchange.getResponse();
        DataBufferFactory bufferFactory = originalResponse.bufferFactory();
        ServerHttpResponseDecorator decoratedResponse = new ServerHttpResponseDecorator(originalResponse) {
            @Override
            public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
                if (body instanceof Flux) {
                    Flux<? extends DataBuffer> fluxBody = (Flux<? extends DataBuffer>) body;
                    return super.writeWith(fluxBody.buffer().map(dataBuffers -> {
                        //解决返回体分段传输
                        List<String> list = Lists.newArrayList();
                        final String[] result = {""};
                        final int[] arrayFlag = {-1};
                        dataBuffers.forEach(dataBuffer -> {
                            try {
                                byte[] content = new byte[dataBuffer.readableByteCount()];
                                dataBuffer.read(content);
                                DataBufferUtils.release(dataBuffer);
                                String item = new String(content, "utf-8");
                                if (arrayFlag[0] == -1 && !item.equals("") && item.substring(0, 1).equals("[")) {
                                    //array
                                    arrayFlag[0] = 1;
                                } else if (arrayFlag[0] == -1 && !item.equals("") && item.substring(0, 1).equals("{")) {
                                    //object
                                    arrayFlag[0] = 2;
                                }
                                result[0] += item;
                            } catch (Exception e) {
                                log.info("失败原因：{}", Throwables.getStackTraceAsString(e));
                            }
                        });
                        JSONObject json = new JSONObject();
                        if (HttpStatus.OK.equals(originalResponse.getStatusCode())) {
                            json.put("code", "10086200");
                            json.put("message", "success");
                        } else {
                            json.put("code", "10086400");
                            json.put("message", "fail");
                        }
                        if (arrayFlag[0] == 1) {
                            json.put("data", JSONArray.parseArray(result[0]));
                        } else if (arrayFlag[0] == 2) {
                            json.put("data", JSONObject.parseObject(result[0]));
                        } else {
                            json.put("data", result[0]);
                        }
                        log.info("【AfterGatewayFilter】返回结果："+json+"\n");
                        byte[] uppedContent = new String(json.toString().getBytes(), Charset.forName("UTF-8")).getBytes();
                        originalResponse.getHeaders().setContentLength(uppedContent.length);
                        return bufferFactory.wrap(uppedContent);
                    }));
                }
                return super.writeWith(body);
            }
        };

        // replace response with decorator
        return chain.filter(exchange.mutate().response(decoratedResponse).build());
    }

    @Override
    public int getOrder() {
        //WRITE_RESPONSE_FILTER 之前执行
        return NettyWriteResponseFilter.WRITE_RESPONSE_FILTER_ORDER - 1;
    }
}
