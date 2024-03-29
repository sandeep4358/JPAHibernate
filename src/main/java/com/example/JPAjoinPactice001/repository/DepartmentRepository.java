package com.example.JPAjoinPactice001.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.JPAjoinPactice001.bean.Department;
import com.example.JPAjoinPactice001.bean.DeptEmpDto;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	@Query("SELECT new com.example.JPAjoinPactice001.bean.DeptEmpDto(d.name, e.name, e.email, e.address) "
			+ "FROM Department d LEFT JOIN d.employees e")
	List<DeptEmpDto> fetchEmpDeptDataLeftJoin();

	@Query("SELECT new com.example.JPAjoinPactice001.bean.DeptEmpDto(d.name, e.name, e.email, e.address) "
			+ "FROM Department d RIGHT JOIN d.employees e")
	List<DeptEmpDto> fetchEmpDeptDataRightJoin();
	
	

}