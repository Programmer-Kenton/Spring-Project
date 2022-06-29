package com.kenton.proxy;

import com.kenton.packageOne.service.SomeService;
import com.kenton.packageOne.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Kenton
 * @description 测试类
 * @date: 2022/6/21 21:57
 */
public class SpringTest {
    @Test
    public void test01(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从容器中获取目标对象
        SomeService proxy = (SomeService) ctx.getBean("someService");
        // 通过代理的对象执行方法 实现目标方法执行时 增强了功能
        proxy.doSome("lisi",20);
    }

    @Test
    public void test02(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从容器中获取目标对象
        SomeService proxy = (SomeService) ctx.getBean("someService");
        // 通过代理的对象执行方法 实现目标方法执行时 增强了功能
        String str = proxy.doOther("zs", 28);
        System.out.println("str=" + str);
    }

    @Test
    public void test03(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从容器中获取目标对象
        SomeService proxy = (SomeService) ctx.getBean("someService");
        // 通过代理的对象执行方法 实现目标方法执行时 增强了功能
        String str = proxy.doFirst("zhangsan", 20);  // myAround
        System.out.println("str=" + str);
    }

    @Test
    public void test04(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从容器中获取目标对象
        SomeService proxy = (SomeService) ctx.getBean("someService");
        // 通过代理的对象执行方法 实现目标方法执行时 增强了功能
        proxy.doSecond();
    }

    @Test
    public void test05(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从容器中获取目标对象
        SomeServiceImpl proxy = (SomeServiceImpl) ctx.getBean("someService");
        System.out.println("proxy:" + proxy.getClass().getName());
        // 通过代理的对象执行方法 实现目标方法执行时 增强了功能
        proxy.doThird();
    }
}
