package com.example.demo.model;

import java.time.LocalDate;

public class Student {
    private String id;
    private String fname;
    private String lname;
    private Integer age;
    private LocalDate dob;
    private String email;

    public Student() {
    }

    public Student(String id, String fname, String lname , Integer age, LocalDate dob, String email) {
        this.id = id;
        this.fname = fname;
        this.age = age;
        this.dob = dob;
        this.email = email;
    }

    public Student(String fname, Integer age, LocalDate dob, String email) {
        this.fname = fname;
        this.age = age;
        this.dob = dob;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getFName() {
        return fname;
    }

    public String getLName() {
        return lname;
    }

    public Integer getAge() {
        return age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFName(String fname) {
        this.fname = fname;
    }

    public void setLName(String lname) {
        this.lname = lname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
                "id: " + id +
                ", fname: " + fname + "lname: " + lname +
                ", age: " + age +
                ", dob: " + dob +
                ", email: " + email +
                "}";
    }
}
