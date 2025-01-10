package org.hoxton.messagequeue.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.hoxton.messagequeue.dto.BaseRabbitMqMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class MessageQueueProducer {

    private Logger log = Logger.getLogger(this.getClass().getName());

    private final   RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.routekey.name}")
    String routeKey;
    @Value("${rabbitmq.exchange.name}")
    String exchangeName;
    @Value("${rabbitmq.queue.name}")
    String queueName;

    public void sendMessage(BaseRabbitMqMessage message){
        log.info("呼叫到MessageQueueProducer");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonMessage = null;
        try {
            jsonMessage = objectMapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        rabbitTemplate.convertAndSend(exchangeName, routeKey, jsonMessage);
    }

}
