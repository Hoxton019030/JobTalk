package org.hoxton.messagequeue.dto;

import lombok.Data;
import org.hoxton.messagequeue.enumerate.RabbitMQEvent;

import java.io.Serial;
import java.io.Serializable;

@Data
public class BaseRabbitMqMessage implements Serializable {
    RabbitMQEvent rabbitMQEvent;
}
