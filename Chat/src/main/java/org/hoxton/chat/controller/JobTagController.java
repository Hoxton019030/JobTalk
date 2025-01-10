package org.hoxton.chat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hoxton.chat.entity.JobTag;
import org.hoxton.chat.response.Response;
import org.hoxton.common.redis.service.RedisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/message")
@RestController
@RequiredArgsConstructor
@Slf4j
public class JobTagController {

    private final RedisService redisService;

    public Response<List<JobTag>> getTop10JobTag(){
        List<JobTag> jobTags = new ArrayList<>();
//        redisService.setValue()
        JobTag.builder().jobName("工程師").build();
        return Response.success(jobTags);
    }
}
