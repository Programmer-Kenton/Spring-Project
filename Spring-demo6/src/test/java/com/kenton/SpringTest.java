package com.kenton;

import com.kenton.dao.StudentDao;
import com.kenton.pojo.Student;
import com.kenton.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author: Kenton
 * @description 测试类
 * @date: 2022/6/22 14:37
 */
public class SpringTest {

    @Test
    public void test01(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("容器中对象名称:"+"name"+"|"+ctx.getBean(name).getClass());
        }
    }

    @Test
    public void testDaoInsert(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao dao = (StudentDao) ctx.getBean("studentDao");
        Student student = new Student();
        student.setId(1013);
        student.setName("周峰");
        student.setEmail("zhoufeng@qq.com");
        student.setAge(20);
        int nums = dao.insertStudent(student);
        System.out.println("nums=" + nums);
    }

    @Test
    public void testServiceInsert(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService service = (StudentService) ctx.getBean("studentService");
        Student student = new Student();
        student.setId(1014);
        student.setName("李胜利");
        student.setEmail("lishengli@qq.com");
        student.setAge(26);
        int nums = service.addStudent(student);
        System.out.println("nums=" + nums);
    }

    @Test
    public void testServiceSelect(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService service = (StudentService) ctx.getBean("studentService");
        List<Student> students = service.queryStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
