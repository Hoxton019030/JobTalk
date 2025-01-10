package org.hoxton.user.consumer;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hoxton.messagequeue.dto.SendMailMessage;
import org.hoxton.messagequeue.enumerate.RabbitMQEvent;
import org.hoxton.messagequeue.service.MessageQueueService;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.core.Message;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserMessageQueueConsumer {
    //    @
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final MessageQueueService messageQueueService;


    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void process(Message  message) {
        byte[] body = message.getBody();
        String jsonString = new String(body);
        JSONObject jsonObject = JSON.parseObject(jsonString);
        String event = jsonObject.getString("rabbitMQEvent");

        if (event.equals(RabbitMQEvent.SEND_MAIL.name())) {
            SendMailMessage sendMailMessage = null;
            try {
                sendMailMessage = objectMapper.readValue(jsonString, SendMailMessage.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            log.info("123{}", sendMailMessage);

        }
        log.info("呼叫到Consumer");
        log.info("接收到的消息" + new String(body));
    }
}
