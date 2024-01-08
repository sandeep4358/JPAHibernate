package com.example.JPAjoinPactice001.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JPAjoinPactice001.bean.Department;
import com.example.JPAjoinPactice001.bean.Employee;
import com.example.JPAjoinPactice001.service.EmployeeService;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }
    
    @GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
}