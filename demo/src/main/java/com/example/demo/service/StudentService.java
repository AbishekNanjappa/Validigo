package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    public List<Student> getStudents();

    public String insertStudent(Student student);

    public String validateStudent(Student student);
}
