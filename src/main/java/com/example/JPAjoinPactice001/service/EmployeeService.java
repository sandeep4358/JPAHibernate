package com.example.JPAjoinPactice001.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JPAjoinPactice001.bean.Employee;
import com.example.JPAjoinPactice001.bean.key.EmployeeId;
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
    	return null;
//        return employeeRepository.findAllById(employeeId)
//                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));
    }
    
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    /**
     * find by employee id
     * @param employeeId
     * @return
     */
    public Employee getEmployeeById(EmployeeId employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }
    
    public Employee updateEmployee(EmployeeId employeeId, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(employeeId).orElse(null);

        if (existingEmployee != null) {
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            existingEmployee.setAddress(updatedEmployee.getAddress());
            existingEmployee.setDepartment(updatedEmployee.getDepartment());

            return employeeRepository.save(existingEmployee);
        }

        return null;
    }
    

    public void deleteEmployee(EmployeeId employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}
