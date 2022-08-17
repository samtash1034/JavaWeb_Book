package com.sam.service;

import com.sam.pojo.User;

public interface UserService {

    /**
     * 註冊
     * @param user
     */
    public void registUser(User user);

    /**
     * 登入
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 帳號是否重複
     * @param username
     * @return
     */
    public boolean existsUsername(String username);


}
