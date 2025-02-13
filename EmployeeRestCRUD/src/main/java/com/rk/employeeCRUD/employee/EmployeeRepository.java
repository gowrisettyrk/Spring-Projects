package com.rk.employeeCRUD.employee;

import com.rk.employeeCRUD.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
