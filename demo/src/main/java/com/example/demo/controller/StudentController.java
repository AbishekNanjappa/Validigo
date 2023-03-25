package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.yaml.snakeyaml.introspector.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;
    private Environment environment;

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> getStudents()
    {
        ResponseEntity<List<Student>> responseEntity = null;
        logger.debug("Request: GET Path: /students");
        List<Student> student = studentService.getStudents();
        responseEntity = new ResponseEntity<List<Student>>(student , HttpStatus.OK);
        logger.debug("Status: " + responseEntity.getStatusCodeValue() + " Body: "+ responseEntity.getBody().toString());
        return responseEntity;
    }

    @PostMapping(value = "/students", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertStudent(@RequestBody Student student) throws Exception
    {
        ResponseEntity<String> response = null;
        logger.debug("Request: POST Path: /students");
        try{
            String s1 = studentService.insertStudent(student);
            response = new ResponseEntity<String>(s1, HttpStatus.CREATED);
            logger.debug("Status: " + response.getStatusCodeValue() + " Body: "+ response.getBody());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            String errorMessage = environment.getProperty(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage, e);
        }
        return response;
    }

    @PostMapping(value = "/validate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> validateStudent(@RequestBody Student student) throws Exception{
        ResponseEntity<String> response = null;
        logger.debug("Request: POST Path: /validate");
        try{
            String s1 = studentService.validateStudent(student);
            response = new ResponseEntity<String>(s1, HttpStatus.CREATED);
            logger.debug("Status: " + response.getStatusCodeValue() + " Body: "+ response.getBody());
        }
        catch(Exception e)
        {
            String errorMessage = environment.getProperty(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage, e);
        }
        return response;
    }
}
