package org.hoxton.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hoxton.user.request.SendEmailRequest;
import org.hoxton.user.service.MailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(SendEmailRequest sendEmailRequest){
        String result=mailService.sendEmail(sendEmailRequest);
        return ResponseEntity.ok(result);
    }

}
