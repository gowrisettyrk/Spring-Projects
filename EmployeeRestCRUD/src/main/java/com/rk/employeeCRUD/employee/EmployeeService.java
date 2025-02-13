package com.rk.employeeCRUD.employee;

import com.rk.employeeCRUD.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int employeeid) {
        Optional<Employee> employee = employeeRepository.findById(employeeid);
        return employee.get();
    }

    public int addEmployee(Employee employee) {
        Employee newEmployee = employeeRepository.save(employee);
        return newEmployee.getId();
    }

    public List<Employee> updateEmployee(int employeeid, Employee employee) {
        List <Employee> emp = getAllEmployees();
        emp.remove(employeeid);
        emp.add(employee);
        return emp;
    }

    public int deleteEmployee(int emloyeeid) {
        employeeRepository.deleteById(emloyeeid);
        return emloyeeid;
    }
}
