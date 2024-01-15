package com.example.JPAjoinPactice001.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JPAjoinPactice001.bean.Department;
import com.example.JPAjoinPactice001.bean.Employee;
import com.example.JPAjoinPactice001.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {    				
      log.info("employee :: {}",employee);
    	return employeeRepository.save(employee);
    }
    
    public Employee getEmployee(Long employeeId) {
        return employeeRepository.findByEmpID(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));
    }
    
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
