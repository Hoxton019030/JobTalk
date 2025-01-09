package org.hoxton.messagequeue.dto;

import lombok.Data;
import org.hoxton.messagequeue.enumerate.RabbitMQEvent;

@Data
public class SendMailMessage extends BaseRabbitMqMessage {
    String title;
    String content;
    String to;
    public SendMailMessage() {
        setRabbitMQEvent(RabbitMQEvent.SEND_MAIL);
    }
}
