package com.lck.dao;


import com.lck.entity.Book;

import java.util.List;

/***
 #Create by LCK on 2021/12/3  19:47
 */
public interface BookDao{

    /**
     * @return: int 添加图书
     */
    public int addBook(Book book);
    /**
     * @return: int 删除图书
     */
    public int deleteBookById(Integer id);
    /**
     * @return: int 修改图书
     */
    public int updateBook(Book book);
    /**
         根据id查询图书
     */
    public Book queryBookById(Integer id);
    /**
        查询图书list
     */
    public List<Book> queryBooks();
    /**
     * @return: java.lang.Integer 求总记录数
     */
    Integer queryForPageTotalCount();

    /**
     * @return: java.util.List<com.lck.entity.Book> 求当前页数据
     */
    List<Book> queForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queForPageItemsByPrice(int begin, int pageSize,int min,int max);
}
