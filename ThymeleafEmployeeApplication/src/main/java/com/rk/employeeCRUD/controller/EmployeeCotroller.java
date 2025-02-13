package com.rk.employeeCRUD.controller;

import com.rk.employeeCRUD.employee.EmployeeService;
import com.rk.employeeCRUD.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeCotroller {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // get the employees from db
        List<Employee> theEmployees = employeeService.getAllEmployees();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }

    @GetMapping("/addEmployeeForm")
    public String addNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "employee-form";
    }

    @PostMapping("/addNewEmployee")
    public String addNewEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/employees/list";
    }

    @PostMapping("/updateEmployeeForm")
    public String updateEmployee(@RequestParam("employeeId") int id,Model model){
        Employee employee= employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "employee-form";
    }

    @PostMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        employeeService.deleteEmployee(id);
        return "redirect:/employees/list";
    }

}
