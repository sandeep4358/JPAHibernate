package com.example.JPAjoinPactice001.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JPAjoinPactice001.bean.Department;
import com.example.JPAjoinPactice001.bean.DeptEmpDto;
import com.example.JPAjoinPactice001.service.DepartmentService;
import com.example.JPAjoinPactice001.service.JoinQueryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/dept")
@RequiredArgsConstructor
@Slf4j
public class DepartmentController {

	@Autowired
	private JoinQueryService joinQueryService;

	private final DepartmentService departmentService;

	@GetMapping("/employees/left")
	public ResponseEntity<List<DeptEmpDto>> getDeptEmployeesLeftJoin() {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesLeftJoin(), HttpStatus.OK);
	}

	@GetMapping("/employees/right")
	public ResponseEntity<List<DeptEmpDto>> getDeptEmployeesRightJoin() {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesRightJoin(), HttpStatus.OK);
	}

	@GetMapping("/employees/inner")
	public ResponseEntity<List<DeptEmpDto>> getDeptEmployeesInnerJoin() {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesInnerJoin(), HttpStatus.OK);
	}

	@GetMapping("/employees/cross")
	public ResponseEntity<List<DeptEmpDto>> getDeptEmployeesCrossJoin() {
		return new ResponseEntity<List<DeptEmpDto>>(joinQueryService.getDeptEmployeesCrossJoin(), HttpStatus.OK);
	}

	@PostMapping("/save")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("Request send by the user department {}",department);
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/{departmentId}")
	public Department getDepartment(@PathVariable Long departmentId) {
		return departmentService.getDepartment(departmentId);
	}

	@GetMapping
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}
}
