package com.kenton.service;

import com.kenton.pojo.Student;

import java.util.List;

public interface StudentService {

    int addStudent(Student student);
    List<Student> queryStudents();
}
