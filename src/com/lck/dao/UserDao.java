package com.lck.dao;

import com.lck.entity.User;

/***
 #Create by LCK on 2021/12/1  23:03
 */
public interface UserDao {
    /**
     * @return: com.lck.pojo.User 根据用户名查询用户信息
     */
    public User queryUserByUsername(String name);
    /**
     * @return: com.lck.pojo.User 根据用户名和密码查询用户信息
     */
    public  User queryUserByUsernameAndPassword(String username,String password);

    /**
     * @return: int 保存用户信息
     */

    public int saveUser(User user);
}
