package com.rk.cruddemo.student;

import com.rk.cruddemo.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

     public Student updateStudent (){

        Student tempstud = repository.findById(7).get();
        tempstud.setFirstName("Ravi");
        tempstud.setLastName("Kumar");
        tempstud.setEmail("ravi@gmail.com");
        return repository.save(tempstud);

    }
}
