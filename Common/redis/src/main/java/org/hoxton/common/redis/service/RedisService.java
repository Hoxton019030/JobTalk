package org.hoxton.common.redis.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
@Slf4j
public class RedisService {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;

    public boolean setValue(String key, Object value, Integer ttl) {
        if (value instanceof List) {
            // 如果是 List，使用 opsForList
            List<?> list = (List<?>) value;
            String jsonString = JSONArray.toJSONString(value);
            log.info(jsonString);
            redisTemplate.opsForValue().set(key, jsonString);
        } else {
            // 否則使用 opsForValue
            redisTemplate.opsForValue().set(key, value);
        }
        return true;
    }

    public <T>List<T> getListValue(String key,Class<T> clazz) {
        String json = (String) redisTemplate.opsForValue().get(key);
        if(json!=null){
            JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
            try {
                return objectMapper.readValue(json, javaType);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return new ArrayList<>();  // 如果取不到值，返回空List
    }
}
