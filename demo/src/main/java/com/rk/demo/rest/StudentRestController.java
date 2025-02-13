package com.rk.demo.rest;

import com.rk.demo.entity.Student;
import com.rk.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/students")
    public List<Student> retriveAllStudents(){
        return studentService.retriveAllStudents();
    }

    @GetMapping("/students/{studentId}")
    public Student retirveStudentById(@PathVariable String studentId){
        Student student = studentService.retirveStudentById(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student not found - " + student);
        }
        return student;
    }

}
