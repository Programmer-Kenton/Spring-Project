package com.kenton.dao;

import com.kenton.pojo.Student;

import java.util.List;

public interface StudentDao {
    int insertStudent(Student student);
    List<Student> selectStudents();
}
