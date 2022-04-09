package com.lck.dao.impl;

import com.lck.dao.BaseDao;
import com.lck.dao.BookDao;
import com.lck.entity.Book;

import java.util.List;

/***
 #Create by LCK on 2021/12/3  19:52
 */
public class BookDaoImpl extends BaseDao implements BookDao {


    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(name,author,price,sales,stock,img_path) values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql ="update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id = ?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql  ="select id,name,author,price,sales,stock,img_path as imgPath from t_book where id = ?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql  = "select id,name,author,price,sales,stock,img_path as imgPath from t_book";
        return queryForList(Book.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql  = "select count(*) from t_book";
         Number count = (Number) queryForSingleValue(sql);
         return count.intValue();
    }

    @Override
    public List<Book> queForPageItems(int begin, int pageSize) {
        String sql  = "select id,name,author,price,sales,stock,img_path imtPath from t_book limit ?,? ";
        return queryForList(Book.class, sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql  = "select count(*) from t_book where price between ? and ? ";
        Number count = (Number) queryForSingleValue(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<Book> queForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql  = "select id,name,author,price,sales,stock,img_path imtPath from" +
                " t_book where price between ? and ? order by price limit ?,? ";
        return queryForList(Book.class, sql,min,max,begin,pageSize);
    }
}