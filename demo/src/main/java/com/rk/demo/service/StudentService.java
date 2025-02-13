package com.rk.demo.service;

import com.rk.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
@Service
public class StudentService {

    static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student("Stu1","Rama","Krishna"));
        students.add(new Student("Stu2","Lakshmi","Sravanthi"));
        students.add(new Student("Stu3","Sandhya","Kanala"));
    }
    public List<Student> retriveAllStudents() {
        return students;
    }

    Student student = new Student();

    public Student retirveStudentById(String studentId) {
        Predicate<? super Student> predicate= student -> student.getId().equalsIgnoreCase(studentId);
        Optional<Student> optinalSurvey = students.stream().filter(predicate).findFirst();
        return optinalSurvey.get();
    }
}
