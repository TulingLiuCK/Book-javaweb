package com.lck.utils;

import com.lck.entity.User;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/***
 #Create by LCK on 2021/12/2  20:50
 */
public class WebUtils {
    /**
     * 把Map中的值注入到对应的JavaBean属性中。
     * @param value
     * @param bean
     */
    public static <T> T copyParamToBean( Map value , T bean ){
        try {
            System.out.println("注入之前：" + bean);
            /**
             * 把所有请求的参数都注入到user对象中
             */
            BeanUtils.populate(bean, value);
            System.out.println("注入之后：" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * @return: int 将字符串转换成为int类型
     */
    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}
