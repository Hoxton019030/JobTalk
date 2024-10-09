package org.hoxton.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "User")
public class User {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 用戶真實姓名
     */
    @Column(name = "name")
    private String name;
    /**
     * 用戶註冊信箱
     */
    @Column(name = "e-mail")
    private String email;
    /**
     * 用戶註冊密碼
     */
    @Column(name = "password")
    private String password;
    /**
     * 用戶註冊時間
     */
    @Column(name = "create_time")
    private String createTime;
    /**
     * 用戶最後登入時間
     */
    @Column(name = "last_login_time")
    private String lastLoginTime;
    /**
     * 用戶最後登入IP
     */
    @Column(name = "last_login_ip")
    private String lastLoginIp;


}
