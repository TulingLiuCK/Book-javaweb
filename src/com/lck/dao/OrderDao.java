package com.lck.dao;

import com.lck.entity.Order;

import java.util.List;

/***
 #Create by LCK on 2021/12/10  22:47
 */
public interface OrderDao {
    public int saveOrder(Order order);
    //查询全部订单
    public List<Order> queryOrders();

    public Order queryOrdersByUserId(String userId);


}
