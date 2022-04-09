package com.lck.test;

import com.lck.entity.Cart;
import com.lck.entity.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/***
 #Create by LCK on 2021/12/9  20:05
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(10),new BigDecimal(10)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(10),new BigDecimal(10)));
        cart.addItem(new CartItem(2,"数据结构",2,new BigDecimal(100),new BigDecimal(100)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(10),new BigDecimal(10)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(10),new BigDecimal(10)));
        cart.addItem(new CartItem(2,"数据结构",2,new BigDecimal(100),new BigDecimal(100)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(10),new BigDecimal(10)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(10),new BigDecimal(10)));
        cart.addItem(new CartItem(2,"数据结构",2,new BigDecimal(100),new BigDecimal(100)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(10),new BigDecimal(10)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(10),new BigDecimal(10)));
        cart.addItem(new CartItem(2,"数据结构",2,new BigDecimal(100),new BigDecimal(100)));
        cart.clear();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(10),new BigDecimal(10)));
        cart.updateCount(1, 10);
        System.out.println(cart);
    }
}