package org.hoxton.messagequeue.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Slf4j
public class RabbitConsumer {
    private Logger log = Logger.getLogger(RabbitConsumer.class.getName());


    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void process(Message message)  {
        byte[] body = message.getBody();
        log.info("呼叫到Consumer");
        log.info("接收到的消息" + new String(body));
    }
}
