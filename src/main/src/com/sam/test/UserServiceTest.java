package com.sam.test;

import com.sam.pojo.User;
import com.sam.service.UserService;
import com.sam.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null, "andy", "22", "andy@gmail.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "am", "123", null)));
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("andy") == true){
            System.out.println("用戶名已存在！");
        }else{
            System.out.println("用戶可用！");
        }
    }
}