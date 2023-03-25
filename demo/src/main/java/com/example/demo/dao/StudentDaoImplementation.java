package com.example.demo.dao;

import com.example.demo.entity.StudentEntity;
import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoImplementation implements StudentDao{
    @PersistenceContext
    private EntityManager em;
    public List<Student> getStudents() {
        Query query = em.createQuery("SELECT u FROM StudentEntity u");
        List<StudentEntity> studentEntity = query.getResultList();
        List<Student> studentList = new ArrayList<Student>();
        if(studentEntity.isEmpty())
        {
            return studentList;
        }
        for(StudentEntity i : studentEntity)
        {
            Student student = new Student();
            student.setId(i.getId());
            student.setFName(i.getFName());
            student.setLName(i.getLName());
            student.setAge(i.getAge());
            student.setDob(i.getDob());
            student.setEmail(i.getEmail());
            studentList.add(student);
        }
        System.out.println("StudentDaoImplementation ended");
        return studentList;
    }
    public String insertStudentDetails(Student student)
    {
        StudentEntity s1 = new StudentEntity();
        s1.setId(student.getId());
        s1.setFName(student.getFName());
        s1.setLName(student.getLName());
        s1.setAge(student.getAge());
        s1.setDob(student.getDob());
        s1.setEmail(student.getEmail());
        System.out.println("Before persist");
        em.persist(s1);
        System.out.println("After persist");
        return "Insertion successful";
    }
    public String validateStudent(Student student)
    {
        StudentEntity se = em.find(StudentEntity.class, student.getId());
        if(se != null)
        {
            if(se.getFName().equalsIgnoreCase(student.getFName()) && se.getLName().equalsIgnoreCase(student.getLName()))
            {
                return "Validation successful";
            }
        }
        return "Validation failed";
    }
}
