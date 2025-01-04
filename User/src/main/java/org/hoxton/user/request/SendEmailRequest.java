package org.hoxton.user.request;

import lombok.Data;

@Data
public class SendEmailRequest {
    String toAddress;
    String fromAddress;
    String title;
    String content;
}
