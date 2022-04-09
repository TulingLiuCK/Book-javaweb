package com.lck.test;

import com.lck.entity.User;
import com.lck.service.UserService;
import com.lck.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/***
 #Create by LCK on 2021/12/1  23:08
 */
public class UserSercieTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null,"asdfa", "fakdlsf","asdf@qq.com"));
    }

    @Test
    public void login() {
        userService.login(new User("admin", "admin" ));
    }

    @Test
    public void existsUsername() {
    }
}