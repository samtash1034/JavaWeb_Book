package com.sam.dao.impl;

import com.sam.dao.BaseDao;
import com.sam.dao.UserDao;
import com.sam.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {

    /**
     * 驗證帳號是否重複
     * @param username
     * @return
     */
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select id,username,password,email from t_user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    /**
     * 驗證登入時的帳密
     * @param username
     * @param password
     * @return
     */
    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password,email from t_user where username = ? and password = ?";
        return queryForOne(User.class, sql, username, password);
    }

    /**
     * 新增用戶
     * @param user
     * @return
     */
    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email) values(?,?,?)";//id自增不用
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
