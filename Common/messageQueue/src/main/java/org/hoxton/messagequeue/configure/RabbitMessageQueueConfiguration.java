package org.hoxton.messagequeue.configure;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Configuration
@Slf4j
public class RabbitMessageQueueConfiguration {

    private ConnectionFactory connectionFactory;
    @Value("${rabbitmq.exchange.name}")
    String exchangeName;
    @Value("${rabbitmq.routekey.name}")
    String userRouteKey;
    @Value("${rabbitmq.queue.name}")
    String userQueueName;

    @Bean
    public ConnectionFactory connectionFactory() {
        return connectionFactory;
    }

    @PostConstruct
    public void setupRabbitMQ() throws IOException, TimeoutException {
        // 使用 connectionFactory bean 创建连接
        log.info("RabbitMQ 初始化中");
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setUsername("hoxton");
        connectionFactory.setPassword("123456");
        connectionFactory.setPort(5672);
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT, true, false, null);

        channel.queueDeclare(userQueueName, true, false, false, null);
        channel.queueBind(userQueueName, exchangeName, userRouteKey);


        channel.close();
        connection.close();
        log.info("RabbitMQ 初始化完成");

    }

}

