package com.kenton;

import com.kenton.pojo.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Kenton
 * @description Spring测试类1
 * @date: 2022/6/17 18:05
 */
public class SpringTest01 {
    @Test
    public void test01(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-total.xml");
        Student myStudent = (Student) ctx.getBean("myStudent");
        System.out.println("student对象=" + myStudent);
    }

    @Test
    public void testByType(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-total.xml");
        Student myStudent = (Student) ctx.getBean("myStudent");
        System.out.println("student对象=" + myStudent);
    }
}
