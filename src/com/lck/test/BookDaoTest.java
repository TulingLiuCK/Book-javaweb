package com.lck.test;

import com.lck.dao.BookDao;
import com.lck.dao.impl.BookDaoImpl;
import com.lck.entity.Book;
import com.lck.entity.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/***
 #Create by LCK on 2021/12/3  20:17
 */
public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book("test1", "test1", new BigDecimal(100), 100,100,null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(47);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(47,"test2", "test2", new BigDecimal(100), 100,100,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(47));
    }

    @Test
    public void queryBooks() {
        bookDao.queryBooks().forEach(System.out::println);
    }
    @Test
    public void queryForPageTotalCount(){
        System.out.println(bookDao.queryForPageTotalCount());
    }
    @Test
    public void queryForPageTotalCountByPrice(){
        System.out.println(bookDao.queryForPageTotalCountByPrice(10, 50));
    }
    @Test
    public void queForPageItems(){
        for (Book queForPageItem : bookDao.queForPageItems(0, 4)) {
            System.out.println(queForPageItem);
        }
    }
    @Test
    public void queForPageItemsByPrice(){
        for (Book queForPageItem : bookDao.queForPageItemsByPrice(0, Page.PAGE_SIZE,10,50)) {
            System.out.println(queForPageItem);
        }
    }
}