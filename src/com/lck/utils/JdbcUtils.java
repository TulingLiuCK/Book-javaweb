package com.lck.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/***
 #Create by LCK on 2021/11/28  15:09
 */
public class JdbcUtils {
    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    static {

        try {
            Properties properties = new Properties();
            //读取jdbc.properties配置文件
            InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("resources/jdbc.properties");
            //从流中加载
            properties.load(resourceAsStream);
            //创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
//            System.out.println(dataSource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

    /**
     * @return: java.sql.Connection 获取连接池中的连接
     */
    public static Connection getConnection() {
        Connection conn = conns.get();
       if (conn == null){
           try {
               conn = dataSource.getConnection();
               conns.set(conn);//保存到ThreadLocal对象中，供后面的jdbc操作使用
               conn.setAutoCommit(false);//设置事务手动管理
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       return conn;
    }

    /**
     * @return: void 提交事务并释放连接
     */
    public static  void commitAndClose(){
        Connection connection = conns.get();
        if (connection!=null) {// 说明之前使用过连接，操作过数据库
            try {
                connection.commit();//提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();//关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //用完之后一定执行remove操作，否则就会出错（因为Tomcat底层使用了 线程池技术）
        conns.remove();
    }
    /**
     * @return: void 回滚事务并释放连接
     */
    public static  void rollbackAndClose(){
        Connection connection = conns.get();
        if (connection!=null) {// 说明之前使用过连接，操作过数据库
            try {
                connection.rollback();//回滚事务
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();//关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //用完之后一定执行remove操作，否则就会出错（因为Tomcat底层使用了 线程池技术）
        conns.remove();
    }

    /**
     * @return: void 关闭连接
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
     */
}
