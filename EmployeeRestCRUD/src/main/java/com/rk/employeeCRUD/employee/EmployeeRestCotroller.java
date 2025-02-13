package com.rk.employeeCRUD.employee;

import com.rk.employeeCRUD.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestCotroller {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("employees/{employeeid}")
    public Employee getEmployeeById(@PathVariable int employeeid){
        Employee employee = employeeService.getEmployeeById(employeeid);
        if(employee == null)
            throw new RuntimeException("Employee id not found: "+ employeeid);
        return employee;
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee){
        int empId = employeeService.addEmployee(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{employeeId}").buildAndExpand(empId)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/employees/{employeeid}")
    public List<Employee> updateEmployee(@PathVariable int employeeid, @RequestBody Employee employee){
        return employeeService.updateEmployee(employeeid, employee);
    }
    @DeleteMapping("/employees/{employeeid}")
    public ResponseEntity<Object> deleteEmployee (@PathVariable int emloyeeid){
        employeeService.deleteEmployee(emloyeeid);
        return ResponseEntity.noContent().build();
    }
}
