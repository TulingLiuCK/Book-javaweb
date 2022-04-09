package com.lck.test;

import com.lck.dao.OrderItemDao;
import com.lck.dao.impl.OrderDaoImpl;
import com.lck.dao.impl.OrderItemDaoImpl;
import com.lck.entity.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/***
 #Create by LCK on 2021/12/10  22:56
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100),"1234565"));
    }
}