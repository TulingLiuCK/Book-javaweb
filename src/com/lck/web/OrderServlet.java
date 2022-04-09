package com.lck.web;

import com.lck.entity.Cart;
import com.lck.entity.Order;
import com.lck.entity.User;
import com.lck.service.OrderService;
import com.lck.service.impl.OrderServiceImpl;
import com.lck.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/***
 #Create by LCK on 2021/12/10  23:14
 */
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    /**
     * @return: void 生成订单
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //获取UserId
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer userId = loginUser.getId();
        //调用OrderService。createOrder（Cart，Userid）生成订单
        String orderId = orderService.createOrder(cart, userId);


        req.setAttribute("orderId", orderId);
        //请求转发到
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
        req.getSession().setAttribute("orderId", orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }


    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.showAllOrders();
        //通过全部订单保存到Request域中
        req.setAttribute("orders", orders);
        //请求转发到
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);
    }
}
