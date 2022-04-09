package com.lck.dao.impl;

import com.lck.dao.BaseDao;
import com.lck.dao.OrderItemDao;
import com.lck.entity.OrderItem;

/***
 #Create by LCK on 2021/12/10  22:51
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql  = "insert into t_order_item(name,count,price,total_price,order_id) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(), orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
