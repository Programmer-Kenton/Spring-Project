package com.kenton.utils;

import java.util.Date;

/**
 * @author: Kenton
 * @description 工具类
 * @date: 2022/6/21 19:37
 */
public class ServiceTools {
    public static void doLog(){
        System.out.println("非业务方法,方法的执行时间："+new Date());
    }

    public static void doTrans(){
        System.out.println("非业务方法,方法执行完毕,提交事务");
    }
}
