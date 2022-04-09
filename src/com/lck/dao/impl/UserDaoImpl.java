package com.lck.dao.impl;

import com.lck.dao.BaseDao;
import com.lck.dao.UserDao;
import com.lck.entity.User;
import org.apache.commons.dbutils.QueryRunner;

/***
 #Create by LCK on 2021/12/1  23:03
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        String sql  = "select id,username,password,email from t_user where username = ?";
        return queryForOne(User.class, sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password, email from t_user where username = ? and password=?";
        return queryForOne(User.class, sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
