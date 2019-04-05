package com.xchaset.gateway;

import com.xchaset.gateway.config.PathKeyResolver;
import com.xchaset.gateway.filter.JwtGatewayFilterFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    //@Bean
    //public RouteLocator routeLocator(RouteLocatorBuilder builder) {
    //    return builder.routes().route(p -> p.path("/autoGarage/**")
    //            .filters(f -> f.stripPrefix(1))
    //            .uri("lb://autoGarage")
    //    ).build();
//
    //}

    @Bean
    public JwtGatewayFilterFactory jwtGatewayFilterFactory(){
        return new JwtGatewayFilterFactory();
    }


    @Bean
    @Primary
    public KeyResolver pathKeyResolver(){
        return new PathKeyResolver();
    }

    /**
     * 限流key
     * @return
     */
    @Bean
    public KeyResolver userKeyResolver(){
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
    }
}
