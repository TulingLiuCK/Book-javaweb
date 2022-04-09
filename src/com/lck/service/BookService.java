package com.lck.service;

import com.lck.entity.Book;
import com.lck.entity.Page;

import java.util.List;

/***
 #Create by LCK on 2021/12/3  20:57
 */
public interface BookService {
    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
