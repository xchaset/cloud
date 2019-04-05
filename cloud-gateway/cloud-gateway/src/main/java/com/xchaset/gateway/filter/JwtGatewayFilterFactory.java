package com.xchaset.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

public class JwtGatewayFilterFactory extends AbstractGatewayFilterFactory<JwtGatewayFilterFactory.Config> {

    /**
     * 构造函数 需要对调用父类的构造函数，否则会报类型转换异常
     */
    public JwtGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String authorization = request.getHeaders().getFirst("Authorization");
            if (authorization == null || authorization.equals("")) {
                ServerHttpResponse response = exchange.getResponse();
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                String msg = "unAuthorized";
                //设置headers
                HttpHeaders httpHeaders = response.getHeaders();
                httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
                httpHeaders.add("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
                //过滤器中跨域需要自己处理
                //设置body
                DataBuffer bodyDataBuffer = response.bufferFactory().wrap(msg.getBytes());
                return response.writeWith(Mono.just(bodyDataBuffer));
            }
            return chain.filter(exchange);
        };
    }

    @Override
    public String name() {
        return "Jwt";
    }

    public static class Config {

    }

}
