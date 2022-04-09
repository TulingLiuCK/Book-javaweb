package com.lck.web;

import com.lck.entity.Book;
import com.lck.entity.Cart;
import com.lck.entity.CartItem;
import com.lck.service.BookService;
import com.lck.service.impl.BookServiceImpl;
import com.lck.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 #Create by LCK on 2021/12/9  22:00
 */
public class CartServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("商品编号"+req.getParameter("id"));
        //获取请求的擦书 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用BookService.queryBookById(id) 得到图书信息
        Book book = bookService.queryBookById(id);
        //把图书信息转换成为CartIem商品项
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //调用Cart.addItem(CartItem)添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);

//        System.out.println("请求头Referer的值："+req.getHeader("Referer"));
        // 最后一个添加的商品名称
        req.getSession().setAttribute("lastName", cartItem.getName());
        //调回商品  重定向原来地址
        resp.sendRedirect(req.getHeader("Referer"));
    }
    /**
     * @return: void 删除商品项
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart!=null){
            //删除购物车商品项目
            cart.deleteItem(id);
            //重定向回原来页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * @return: void 清空购物车
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart!=null){
            //清空购物车
            cart.clear();
            //重定向回原来页面
            resp.sendRedirect(req.getHeader("Referer"));

        }

    }
}
