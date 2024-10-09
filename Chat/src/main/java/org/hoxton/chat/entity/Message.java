package org.hoxton.chat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Table(name = "message")
@Entity(name = "message")
public class  Message {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "content")
    private String content;
    @Column(name = "sender_id")
    private Integer senderId;
    @Column(name = "receiver_id")
    private Integer receiverId;
    @Column(name = "send_time")
    private Date sendTime;

}
