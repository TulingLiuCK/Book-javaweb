package com.lck.service.impl;

import com.lck.dao.BookDao;
import com.lck.dao.OrderDao;
import com.lck.dao.OrderItemDao;
import com.lck.dao.impl.BookDaoImpl;
import com.lck.dao.impl.OrderDaoImpl;
import com.lck.dao.impl.OrderItemDaoImpl;
import com.lck.entity.*;
import com.lck.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/***
 #Create by LCK on 2021/12/10  23:00
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        //订单号
        String orderId =System.currentTimeMillis()+ ""+userId;
        //创建一个订单对象
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(),0,userId);
        //保存订单
        orderDao.saveOrder(order);

        //遍历购物车中每一个商品项转换成为订单项保存到数据库
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()){
            //获取每一个购物车中的商品项目
            CartItem cartItem = entry.getValue();
            //转换成为每一个订单项
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            //保存订单到数据库
            orderItemDao.saveOrderItem(orderItem);
            //更新库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }

        //买完之后清空购物车
        cart.clear();
        return  orderId;
    }

    @Override
    public List<Order> showAllOrders() {
        return orderDao.queryOrders();
    }

    @Override
    public Order showMyOrders(String userId) {
        return orderDao.queryOrdersByUserId(userId);
    }


}
