package org.hoxton.messagequeue.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Component
public class MessageQueueProducer {

    private Logger log = Logger.getLogger(this.getClass().getName());

    private  RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.routekey.name}")
    String routeKey;
    @Value("${rabbitmq.exchange.name}")
    String exchangeName;
    @Value("${rabbitmq.queue.name}")
    String queueName;

    public void sendMessage(String message) {
        log.info("呼叫到MessageQueueProducer");
        rabbitTemplate.convertAndSend(exchangeName, routeKey, message);
    }

}
