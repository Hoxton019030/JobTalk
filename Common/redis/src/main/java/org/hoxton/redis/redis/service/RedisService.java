package org.hoxton.redis.redis.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class RedisService {
    private final RedisTemplate<String, Object> redisTemplate;

    public boolean setValue(String key, Object value, Integer ttl) {
        redisTemplate.opsForValue().set(key, value);
        return true;
    }
}
