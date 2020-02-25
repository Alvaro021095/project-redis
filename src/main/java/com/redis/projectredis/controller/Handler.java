package com.redis.projectredis.controller;

import com.redis.projectredis.consumerredis.Redis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class Handler {

    @Autowired
    Redis redis;

    public Mono<ServerResponse> getValueFromRedis(ServerRequest request){

        String key = request.headers().header("key").get(0);

        Mono<String> result = redis.getKey(key);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(result, String.class);
    }

    public Mono<ServerResponse> saveKeyFromRedis(ServerRequest request){

        String key = request.headers().header("key").get(0);
        String value = request.headers().header("value").get(0);

        Mono<Boolean> result = redis.saveKey(key, value);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(result, Boolean.class);
    }

}
