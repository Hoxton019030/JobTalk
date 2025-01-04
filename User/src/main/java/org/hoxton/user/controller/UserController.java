package org.hoxton.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.hoxton.user.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    public UserController() {
        log.info("初始化");
    }

    @GetMapping("/test")
    public Response<String> test() {
        return Response.success("User Test");
    }

}

