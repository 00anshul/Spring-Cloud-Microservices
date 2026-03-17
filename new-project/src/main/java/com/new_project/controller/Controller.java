package com.new_project.controller;

import com.new_project.Employee;
import com.new_project.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class Controller {

    @Autowired
    private EmployeeService employeeService;

    // POST http://localhost:8080/employees
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    // GET http://localhost:8080/employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}