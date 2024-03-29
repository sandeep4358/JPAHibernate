package com.example.JPAjoinPactice001.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JPAjoinPactice001.bean.Department;
import com.example.JPAjoinPactice001.repository.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public Department saveDepartment(Department department) {
    	//important line in the relation ship.
    	//department.getEmployees().forEach(e->department.addEmployee(e));  // need to check why is it producing cuncurrent modification error.
    	department.getEmployees().forEach(e->e.setDepartment(department));
        return departmentRepository.save(department);
    }
    
    public Department getDepartment(Long departmentId) {
        return departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + departmentId));
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}