package com.rk.cruddemo.student;

import com.rk.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.List;

@Component
public class StudentDetailsCommandLineRunner implements CommandLineRunner {

    private StudentRepository repository;

    @Autowired
    private StudentService studentService;

    public StudentDetailsCommandLineRunner(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        //repository.save(new Student("Sama", "Krishna","srk3@gmail.com"));
        System.out.println(repository.findById(7));
        System.out.println(repository.findByLastName("Krishna"));
        System.out.println(repository.findAll());
        //studentService.updateStudent();
        System.out.println(repository.findById(7));
        repository.deleteById(12);

    }
}

