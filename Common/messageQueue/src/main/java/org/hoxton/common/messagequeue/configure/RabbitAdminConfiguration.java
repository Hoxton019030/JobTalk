package org.hoxton.common.messagequeue.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Slf4j
public class RabbitAdminConfiguration {
    @Value("${spring.rabbitmq.host}")
    private String rabbitmqHost;
    @Bean
    public CachingConnectionFactory cachingConnectionFactory(){
        log.info("rabbitmqHost:{}", rabbitmqHost);
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(rabbitmqHost);
        return cachingConnectionFactory;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(){
        //需要传入
        RabbitAdmin rabbitAdmin = new RabbitAdmin(cachingConnectionFactory());
        rabbitAdmin.setAutoStartup(true);
        return rabbitAdmin;
    }
}
