package org.hoxton.user.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.hoxton.user.service.rpc.UserService;
@Slf4j
@DubboService(timeout = 5000, interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {
    @Override
    public String getUser() {
        return "拿到使用者1";
    }
}
