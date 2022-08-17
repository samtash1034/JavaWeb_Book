package com.sam.test;

import com.sam.dao.UserDao;
import com.sam.dao.impl.UserDaoImpl;
import com.sam.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if(userDao.queryUserByUsername("sam") != null){
            System.out.println("用戶名已存在！");
        }else{
            System.out.println("用戶名可用！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("sam", "123") == null){
            System.out.println("登入失敗！");
        }else{
            System.out.println("登入成功！");
        }
    }

    @Test
    public void saveUser() {
        //新增成功則回傳紀錄數
        System.out.println(userDao.saveUser(new User(null, "kevin", "11", "kevin@gmail.com")));
    }
}