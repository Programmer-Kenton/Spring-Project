package com.kenton;

import com.kenton.pojo.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Kenton
 * @description 测试类
 * @date: 2022/6/17 20:13
 */
public class SpringTest {
    @Test
    public void test01(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student myStudent = (Student) ctx.getBean("myStudent");
        System.out.println(myStudent);
    }
}
