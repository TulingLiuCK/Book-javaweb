package com.lck.test;

import com.lck.dao.UserDao;
import com.lck.dao.impl.UserDaoImpl;
import com.lck.entity.User;
import com.lck.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

/***
 #Create by LCK on 2021/12/1  23:04
 */
public class UserDaoTest {

    private UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        System.out.println(userDao.queryUserByUsername("admin"));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        System.out.println(userDao.queryUserByUsernameAndPassword("admin", "admin"));
    }

    @Test
    public void saveUser() {
        userDao.saveUser(new User(null,"lck","lckadsf","ald@qq.com"));
    }

//    public static void main(String[] args) {
//        QueryRunner queryRunner = new QueryRunner();
//        Connection conn = JdbcUtils.getConnection();
//        String sql = "insert into t_user(username,password,email) values('test','test','test@qq.com')";
//        try {
//            int update = queryRunner.update(conn,sql);
//            System.out.println(update);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
}