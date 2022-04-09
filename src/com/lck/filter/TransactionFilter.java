package com.lck.filter;

import com.lck.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/***
 #Create by LCK on 2021/12/12  12:16
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);

            JdbcUtils.commitAndClose();//提交事务
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();//回滚事务
            e.printStackTrace();
            throw  new RuntimeException(e);//把异常抛给Tomcat展示友好的错误页面
        }
    }

    @Override
    public void destroy() {

    }
}
