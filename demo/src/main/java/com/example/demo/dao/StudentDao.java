package com.example.demo.dao;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> getStudents();
    public String insertStudentDetails(Student student);
    public String validateStudent(Student student);
}
