package com.lck.web;

import com.lck.entity.Book;
import com.lck.entity.Page;
import com.lck.service.BookService;
import com.lck.service.impl.BookServiceImpl;
import com.lck.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/***
 #Create by LCK on 2021/12/3  21:06
 */
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    /**
     * @return: void 处理分页功能
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2调用BookService.page(pageNo,pageSize):page对象
        Page<Book> page = bookService.page(pageNo, pageSize);

        page.setUrl("manager/bookServlet?action=page");
        //3保存page对象到request域中
        req.setAttribute("page", page);
        //4请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        pageNo += 1;
//        String name = req.getParameter("name");
//        String author = req.getParameter("author");
//        String price = req.getParameter("price");
//        String sales = req.getParameter("sales");
//        String stock = req.getParameter("stock");
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.addBook(book);
        //有bug 按f5会重新提交 使用重定向解决
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);


    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用boooService.deleteBookById 删除图书
        bookService.deleteBookById(id);
        //重定向
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用请求的参数=封装称为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //调用bookService.updateBook(book)修改图书
        bookService.updateBook(book);
        //重定向图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1通过BookServcie查询全部图书
        List<Book> books = bookService.queryBooks();
        //2通过全部图书保存到Request域中
        req.setAttribute("books", books);
        //3请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }


    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用bookService.queryBookById查询图书
        Book book = bookService.queryBookById(id);
        //3保存到图书到request域中
        req.setAttribute("book", book);
        //请求转发
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }
}
