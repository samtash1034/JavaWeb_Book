package com.sam.dao;

import com.sam.pojo.User;

public interface UserDao {

    /**
     * 根據用戶名查詢用戶訊息
     * @param username
     * @return
     */
    public User queryUserByUsername(String username);

    /**
     * 根據用戶名和密碼查詢用戶訊息
     * @param username
     * @param password
     * @return
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 新增用戶訊息
     * @param user
     * @return
     */
    public int saveUser(User user);


}
