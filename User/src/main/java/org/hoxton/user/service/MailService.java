package org.hoxton.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hoxton.messagequeue.service.MessageQueueProducerService;
import org.hoxton.redis.redis.service.RedisService;
import org.hoxton.user.request.SendEmailRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {

    private final JavaMailSender mailSender;
    private final MessageQueueProducerService messageQueueProducerService;
//    private final MessageQueueProducerService messageQueueProducerService;
    public String sendEmail(SendEmailRequest sendEmailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(sendEmailRequest.getToAddress());
        message.setSubject(sendEmailRequest.getTitle());
        message.setText(sendEmailRequest.getContent());
        message.setFrom(sendEmailRequest.getFromAddress());
//        mailSender.send(message);
        messageQueueProducerService.sendMessage("安安");
        return "成功";
    }
}
