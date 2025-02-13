package com.rk.cruddemo.student;

import com.rk.cruddemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByLastName(String lastName);
}
