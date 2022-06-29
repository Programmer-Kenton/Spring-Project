package com.kenton;

import com.kenton.service.BuyGoodsService;
import org.apache.ibatis.javassist.ClassPath;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Kenton
 * @description 测试类
 * @date: 2022/6/23 13:28
 */
public class SpringTest {

    @Test
    public void test01(){
       ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
       // 从容器中获取service
       BuyGoodsService service = (BuyGoodsService) ctx.getBean("buyService");
        System.out.println("service是代理:" + service.getClass().getName());
        // 调用方法
        service.buy(1001,10);

    }
}
