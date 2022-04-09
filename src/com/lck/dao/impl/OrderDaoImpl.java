package com.lck.dao.impl;

import com.lck.dao.BaseDao;
import com.lck.dao.OrderDao;
import com.lck.entity.Order;

import java.util.List;

/***
 #Create by LCK on 2021/12/10  22:48
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int saveOrder(Order order) {
        String sql  = "insert into t_order(order_id,create_time,price,status,user_id) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public List<Order> queryOrders() {
        String sql  = "select order_id as orderId,create_time as createTime,price,status,user_id as userId from t_order";
        return queryForList(Order.class,sql);
    }

    @Override
    public Order queryOrdersByUserId(String userId) {
        String sql  = "select order_id as orderId,create_time as createTime,price,status,user_id as userId from t_order where user_id = ? ";
        return queryForOne(Order.class,sql,userId);
    }






}
