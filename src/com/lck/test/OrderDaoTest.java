package com.lck.test;

import com.lck.dao.OrderDao;
import com.lck.dao.impl.OrderDaoImpl;
import com.lck.entity.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/***
 #Create by LCK on 2021/12/10  22:54
 */
public class OrderDaoTest {
    private OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("1234565", new Date(), new BigDecimal(100), 0, 1));
    }
    @Test
    public void queryOrders(){
        orderDao.queryOrders().forEach(System.out::println);
    }

    @Test
    public void queryOrdersByUserId(){
        System.out.println(orderDao.queryOrdersByUserId("1"));
    }
}