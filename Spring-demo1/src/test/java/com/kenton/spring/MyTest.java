package com.kenton.spring;

import com.kenton.pojo.School;
import com.kenton.pojo.Student;
import com.kenton.service.SomeService;
import com.kenton.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author: Kenton
 * @description Spring容器测试类
 * @date: 2022/6/16 19:56
 */
public class MyTest {
    @Test
    public void test01(){
        SomeServiceImpl service = new SomeServiceImpl();
        service.doSome();
    }

    @Test
    public void test02(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService someService = (SomeService) ctx.getBean("someService");
        someService.doSome();
    }

    @Test
    public void test03(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        int nums = ctx.getBeanDefinitionCount();
        System.out.println(nums);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test04(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Date myDate = (Date) ctx.getBean("myDate");
        System.out.println(myDate);
    }


    @Test
    public void test05(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Student myStudent = (Student) ctx.getBean("myStudent");
        System.out.println("student对象=" + myStudent);
    }

    @Test
    public void test06(){
        Student student = new Student();
        student.setName("李成鑫");
        student.setAge(20);

        School school = new School();
        school.setName("清华大学");
        school.setAddress("北京海淀区");

        student.setSchool(school);
        System.out.println("student=" + student);
    }

    @Test
    public void test07(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student myStudent = (Student) ctx.getBean("myStudent");
        System.out.println("student对象=" + myStudent);
    }
}
