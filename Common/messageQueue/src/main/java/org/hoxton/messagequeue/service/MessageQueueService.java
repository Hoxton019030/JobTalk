package org.hoxton.messagequeue.service;

import lombok.RequiredArgsConstructor;
import org.hoxton.messagequeue.dto.BaseRabbitMqMessage;
import org.hoxton.messagequeue.producer.MessageQueueProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageQueueService {
    private final MessageQueueProducer messageQueueProducer;

    public void sendMessage(BaseRabbitMqMessage message) {
        messageQueueProducer.sendMessage(message);
    }



}
