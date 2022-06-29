package com.kenton.service.impl;

import com.kenton.dao.StudentDao;
import com.kenton.pojo.Student;
import com.kenton.service.StudentService;

import java.util.List;

/**
 * @author: Kenton
 * @description
 * @date: 2022/6/22 14:05
 */
public class StudentServiceImpl implements StudentService {
    // 引用类型
    private StudentDao studentDao;
    // 使用set注入 赋值
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        int nums = studentDao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> queryStudents() {
        List<Student> students = studentDao.selectStudents();
        return students;
    }
}
