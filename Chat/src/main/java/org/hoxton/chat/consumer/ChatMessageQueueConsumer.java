package org.hoxton.chat.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ChatMessageQueueConsumer {

//    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void process(Message message) throws InterruptedException {
        byte[] body = message.getBody();
        String s = new String(body);
        log.info("收到消息:{}", s);
    }

}
