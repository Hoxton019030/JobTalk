package org.hoxton.user.consumer;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hoxton.common.messagequeue.dto.SendMailMessage;
import org.hoxton.common.messagequeue.enumerate.RabbitMQEvent;
import org.hoxton.user.request.SendEmailRequest;
import org.hoxton.user.service.MailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.core.Message;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserMessageQueueConsumer {
    //    @
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final MailService mailService;
    private final JavaMailSender javaMailSender;


    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void process(Message  message) throws InterruptedException {
        byte[] body = message.getBody();
        String jsonString = new String(body);
        JSONObject jsonObject = JSON.parseObject(jsonString);
        String event = jsonObject.getString("rabbitMQEvent");

        if (event.equals(RabbitMQEvent.SEND_MAIL.name())) {
            SendMailMessage sendMailMessage = null;
            try {
                sendMailMessage = objectMapper.readValue(jsonString, SendMailMessage.class);
                String title = sendMailMessage.getTitle();
                String content = sendMailMessage.getContent();
                String to = sendMailMessage.getTo();
                SendEmailRequest sendEmailRequest = new SendEmailRequest();
                sendEmailRequest.setToAddress(to);
                sendEmailRequest.setTitle(title);
                sendEmailRequest.setContent(content);
                sendEmail(sendEmailRequest);
                log.info("信件發送成功 {}",sendEmailRequest);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void sendEmail(SendEmailRequest sendEmailRequest){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(sendEmailRequest.getFromAddress());
        simpleMailMessage.setTo(sendEmailRequest.getToAddress());
        simpleMailMessage.setSubject(sendEmailRequest.getTitle());
        simpleMailMessage.setText(sendEmailRequest.getContent());
        javaMailSender.send(simpleMailMessage);
    }
}
