package org.hoxton.redis.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        // 使用 StringRedisSerializer 序列化鍵
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());

        // 使用 GenericToStringSerializer 序列化值
        //setValueSerializer(new GenericToStringSerializer<>(Object.class))：這行代碼告訴 Spring 將 Redis 的值（無論是 Integer、String 還是其他類型）轉換為字符串進行存儲，保證 Integer 不會被序列化為複雜對象結構。
        template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
        //類似地，對 Hash 的值也使用同樣的序列化方式
        template.setHashValueSerializer(new GenericToStringSerializer<>(Object.class));

        return template;
    }

}
