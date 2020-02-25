package com.redis.projectredis.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@EnableAutoConfiguration
public class Router {


    @Bean
    public RouterFunction<ServerResponse> routesIncomes(Handler handler){
        return  route(
                GET("valueKey")
                        .and(accept(APPLICATION_JSON))
                        .and(contentType(APPLICATION_JSON)), handler::getValueFromRedis)
                .andRoute(
                        GET("save")
                        .and(accept(APPLICATION_JSON))
                        .and(contentType(APPLICATION_JSON)), handler::saveKeyFromRedis)
                ;

    }


}
