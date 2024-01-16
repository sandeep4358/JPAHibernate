package com.example.JPAjoinPactice001.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JPAjoinPactice001.bean.Employee;
import com.example.JPAjoinPactice001.bean.key.EmployeeId;
import com.example.JPAjoinPactice001.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/employees")
@Slf4j
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
    
    @DeleteMapping("/delete/{employeeNumber}/{companyNumber}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String employeeNumber, @PathVariable String companyNumber) {
        EmployeeId employeeId = new EmployeeId();
        employeeId.setEmployeeNumber(employeeNumber);
        employeeId.setCompanyNumber(companyNumber);

        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/{employeeNumber}/{companyNumber}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String employeeNumber, @PathVariable String companyNumber, @RequestBody Employee updatedEmployee) {
        EmployeeId employeeId = new EmployeeId();
        employeeId.setEmployeeNumber(employeeNumber);
        employeeId.setCompanyNumber(companyNumber);

        Employee updated = employeeService.updateEmployee(employeeId, updatedEmployee);

        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }
    
    @GetMapping("/findEmployee/{employeeNumber}/{companyNumber}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String employeeNumber, @PathVariable String companyNumber) {
    	log.info("employeeNumber : {} :: companyNumber : {}",employeeNumber,companyNumber);
    	
        EmployeeId employeeId = new EmployeeId();
        employeeId.setEmployeeNumber(employeeNumber);
        employeeId.setCompanyNumber(companyNumber);

        Employee employee = employeeService.getEmployeeById(employeeId);

        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}