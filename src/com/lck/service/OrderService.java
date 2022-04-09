package com.lck.service;

import com.lck.entity.Cart;
import com.lck.entity.Order;

import java.util.List;

/***
 #Create by LCK on 2021/12/10  22:59
 */
public interface OrderService {
    public String createOrder(Cart cart,Integer userId);
    public List<Order> showAllOrders();
    public Order showMyOrders(String userId);
}
