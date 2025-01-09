package org.hoxton.messagequeue.dto;

import lombok.Data;

@Data
public class SendMailMessage extends BaseRabbitMqMessage {
    String title;
    String content;
    String to;
}
