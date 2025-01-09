package org.hoxton.messagequeue.dto;

import lombok.Data;
import org.hoxton.messagequeue.enumerate.RabbitMQEvent;

@Data
public class BaseRabbitMqMessage {
    RabbitMQEvent rabbitMQEvent;
}
