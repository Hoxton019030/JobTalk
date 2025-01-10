package org.hoxton.common.messagequeue.dto;

import lombok.Data;
import org.hoxton.common.messagequeue.enumerate.RabbitMQEvent;

import java.io.Serializable;

@Data
public class BaseRabbitMqMessage implements Serializable {
    RabbitMQEvent rabbitMQEvent;
}
