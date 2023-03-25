package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.dao.StudentDaoImplementation;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentServiceImplementation implements StudentService{
    @Autowired
    private StudentDao studentDao;
    public List<Student> getStudents() {
        List<Student> student = studentDao.getStudents();
        return student;
    }

    public String insertStudent(Student student){
        String s1 = studentDao.insertStudentDetails(student);
        if(s1 == null){
            return "Service.Insertion not successful";
        }
        return s1;
    }

    public String validateStudent(Student student)
    {
        String s1 = studentDao.validateStudent(student);
        if(s1.equalsIgnoreCase("Validation failed")){
            return "Service.validation failed";
        }
        System.out.println(s1);
        return s1;
    }
}
