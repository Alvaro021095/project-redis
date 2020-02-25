package com.redis.projectredis.consumerredis;

import com.fasterxml.jackson.core.io.JsonStringEncoder;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.crypto.spec.PSource;

@Component
public class Redis {

    private final ReactiveRedisOperations<String, String> clientRedis;

    public Redis(ReactiveRedisOperations<String, String> clientRedis) {
        this.clientRedis = clientRedis;
    }

    public Mono<String> getKey(String key) {

        ReactiveValueOperations valueOperations = clientRedis.opsForValue();
        return valueOperations.get(key);

    }

    public Mono<Boolean> saveKey(String key, String value) {

        ReactiveValueOperations valueOperations = clientRedis.opsForValue();
        return valueOperations.set(key, value);

    }

}
