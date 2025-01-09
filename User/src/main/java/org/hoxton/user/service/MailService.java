package org.hoxton.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hoxton.messagequeue.dto.SendMailMessage;
import org.hoxton.messagequeue.enumerate.RabbitMQEvent;
import org.hoxton.messagequeue.producer.MessageQueueProducer;
import org.hoxton.messagequeue.service.MessageQueueService;
import org.hoxton.user.request.SendEmailRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {

    private final JavaMailSender mailSender;
    private final MessageQueueService messageQueueService;
//    private final MessageQueueProducerService messageQueueProducerService;
    public String sendEmail(SendEmailRequest sendEmailRequest) {
        SendMailMessage sendMailMessage = new SendMailMessage();
        sendMailMessage.setRabbitMQEvent(RabbitMQEvent.SEND_MAIL);
        sendMailMessage.setTo(sendEmailRequest.getToAddress());
        sendMailMessage.setTitle(sendEmailRequest.getTitle());
        sendMailMessage.setContent(sendEmailRequest.getContent());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(sendEmailRequest.getToAddress());
        message.setSubject(sendEmailRequest.getTitle());
        message.setText(sendEmailRequest.getContent());
        message.setFrom(sendEmailRequest.getFromAddress());
//        mailSender.send(message);
        messageQueueService.sendMessage(sendMailMessage);
        return "成功";
    }
}
