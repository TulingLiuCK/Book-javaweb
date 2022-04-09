package com.lck.test;

import com.lck.entity.Cart;
import com.lck.entity.CartItem;
import com.lck.entity.Order;
import com.lck.service.OrderService;
import com.lck.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/***
 #Create by LCK on 2021/12/10  23:09
 */
public class OrderServiceTest {
    OrderService orderService  =new OrderServiceImpl();

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(10), new BigDecimal(10)));
        cart.addItem(new CartItem(2, "数据结构", 2, new BigDecimal(100), new BigDecimal(100)));
        System.out.println(orderService.createOrder(cart, 1));
    }

    @Test
    public void showAllOrders() {
        System.out.println(orderService.showAllOrders());
    }
    @Test
    public void showMyOrders(){
        System.out.println(orderService.showMyOrders("1"));
    }
}