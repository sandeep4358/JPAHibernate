package com.example.JPAjoinPactice001;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.JPAjoinPactice001.bean.Department;
import com.example.JPAjoinPactice001.bean.Employee;
import com.example.JPAjoinPactice001.repository.DepartmentRepository;
import com.example.JPAjoinPactice001.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
//@EnableJpaRepositories("com.roytuts.spring.data.jpa.left.right.inner.cross.join.repository")

@RequiredArgsConstructor
public class JpAjoinPactice001Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(JpAjoinPactice001Application.class, args);
	}
	
	final DepartmentRepository deptRepository;
	
	final EmployeeRepository empRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
        System.out.println("Application Started !!");
        
		/*
		 * Employee emp1 =
		 * Employee.builder().email("AKASH@example.com").address("RRRRR").build();
		 * Employee emp2 =
		 * Employee.builder().email("PRAKASH@example.com").address("DDDDD").build();
		 * Employee emp3 =
		 * Employee.builder().email("RAMESH@example.com").address("KJJJJ").build();
		 * 
		 * empRepository.save(emp1); empRepository.save(emp2); empRepository.save(emp3);
		 * 
		 * List<Employee> empList = new ArrayList<>();
		 * 
		 * Department deptIT =
		 * Department.builder().description("IT").employees(empList).build();
		 * 
		 * deptRepository.save(deptIT);
		 */
	}

}
