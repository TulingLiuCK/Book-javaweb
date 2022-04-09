package com.lck.web;

import com.lck.entity.User;
import com.lck.service.UserService;
import com.lck.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 #Create by LCK on 2021/12/2  18:43
 */
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //调用xxxService.xxx处理业务
        User loginUser = userService.login(new User(username, password));
        //根据结果判断是否登录成功 如果等于null说明失败
        if (loginUser==null){
            //错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", username);
            //登录失败跳转到登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);

        }else {
            //登录成功跳转到登录成功页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }


    }
}
