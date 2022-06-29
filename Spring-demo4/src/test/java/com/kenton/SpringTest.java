package com.kenton;

import com.kenton.handler.MyIncationHandler;
import com.kenton.service.SomeService;
import com.kenton.service.impl.SomeServiceImpl;
import com.kenton.service.impl.SomeServiceNewImpl;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author: Kenton
 * @description Spring测试类
 * @date: 2022/6/21 19:31
 */
public class SpringTest {
    // 调用doSome,doOther
    @Test
    public void test01(){
        SomeServiceImpl service = new SomeServiceImpl();
        service.doSome();
        System.out.println("------------------------------------------");
        service.doOther();
    }

    @Test
    public void test02(){
        // 使用JDK的Proxy创建代理对象
        // 创建目标对象
        SomeServiceNewImpl target = new SomeServiceNewImpl();
        // 创建InvocationHandler对象
        MyIncationHandler handler = new MyIncationHandler(target);
        // 使用Proxy创建代理
        SomeService proxy = (SomeService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);

        // 通过代理执行方法 会调用handler中的invoke()方法
        proxy.doSome();
        System.out.println("------------------------------------------------------");
        proxy.doOther();
    }
}
