package com.lck.test;

import com.lck.entity.Book;
import com.lck.service.BookService;
import com.lck.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/***
 #Create by LCK on 2021/12/3  21:00
 */
public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book("test2", "test2", new BigDecimal(100), 100, 100, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(48);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(48, "test3", "test3", new BigDecimal(200), 100, 100, null));

    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(48));
    }

    @Test
    public void queryBooks() {
        bookService.queryBooks().forEach(System.out::println);
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1, 4));
    }
    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1, 4,10,50));
    }
}