package org.hoxton.chat.controller;
import java.util.Date;

import org.hoxton.chat.entity.Message;
import org.hoxton.chat.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/message")
@RestController
public class MessageController {

    @GetMapping("/test")
    public Response<Message> test() {
        Message message = new Message();
        message.setId(1);
        message.setContent("測試");
        message.setSenderId(0);
        message.setReceiverId(0);
        message.setSendTime(new Date());
        return Response.success(message);
    }
}
