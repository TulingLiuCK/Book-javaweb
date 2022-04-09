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
 #Create by LCK on 2021/12/1  23:13
 */
public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //检查验证发是否正确
        if ("abcde".equalsIgnoreCase(code)){
            //验证码正确检查用户名是否正确
            if (userService.existsUsername(username)){
                System.out.println("用户名已经存在");
                req.setAttribute("msg", "用户名已经存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                    //返回true表示已经存在不可用
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else {
                //返回false表示可用 跳转到注册成功页面
                userService.registUser(new User(username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }else {
            //把回显信息保存到Request域中
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            //验证发错误
            System.out.println("验证码错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }


    }
}
