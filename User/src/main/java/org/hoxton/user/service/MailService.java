package org.hoxton.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hoxton.common.messagequeue.dto.SendMailMessage;
import org.hoxton.common.messagequeue.enumerate.RabbitMQEvent;
import org.hoxton.common.messagequeue.service.MessageQueueService;
import org.hoxton.user.request.SendEmailRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {

    private final MessageQueueService messageQueueService;

    public String sendEmail(SendEmailRequest sendEmailRequest) {
        SendMailMessage sendMailMessage = new SendMailMessage();
        sendMailMessage.setRabbitMQEvent(RabbitMQEvent.SEND_MAIL);
        sendMailMessage.setTo(sendEmailRequest.getToAddress());
        sendMailMessage.setTitle(sendEmailRequest.getTitle());
        sendMailMessage.setContent(sendEmailRequest.getContent());
        messageQueueService.sendMessage(sendMailMessage);
        return "成功";
    }
}
