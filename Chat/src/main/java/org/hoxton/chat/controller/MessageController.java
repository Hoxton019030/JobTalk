package org.hoxton.chat.controller;

import java.util.Date;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hoxton.chat.entity.Message;
import org.hoxton.chat.response.Response;
import org.hoxton.redis.redis.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/message")
@RestController
@RequiredArgsConstructor
@Slf4j
public class MessageController {

    private final RedisService redisService;


    @GetMapping("/test")
    public Response<Message> test() {
        log.info("Test");
        Message message = new Message();
        message.setId(1);
        message.setContent("測試");
        message.setSenderId(0);
        message.setReceiverId(0);
        message.setSendTime(new Date());
        redisService.setValue("Test",1,100);
        return Response.success(message);
    }
}
