package org.hoxton.common.messagequeue.service;

import lombok.RequiredArgsConstructor;
import org.hoxton.common.messagequeue.dto.BaseRabbitMqMessage;
import org.hoxton.common.messagequeue.producer.MessageQueueProducer;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageQueueService {
    private final MessageQueueProducer messageQueueProducer;

    public void sendMessage(BaseRabbitMqMessage message) {
        messageQueueProducer.sendMessage(message);
    }



}
