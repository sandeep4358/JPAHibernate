package com.example.JPAjoinPactice001.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.JPAjoinPactice001.bean.DeptEmpDto;
import com.example.JPAjoinPactice001.bean.Employee;
import com.example.JPAjoinPactice001.bean.key.EmployeeId;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, EmployeeId> {

	@Query("SELECT new com.example.JPAjoinPactice001.bean.DeptEmpDto(d.name, e.name, e.email, e.address) "
			+ "FROM Department d INNER JOIN d.employees e")
	List<DeptEmpDto> fetchEmpDeptDataInnerJoin();

	@Query("SELECT new com.example.JPAjoinPactice001.bean.DeptEmpDto(d.name, e.name, e.email, e.address) "
			+ "FROM Department d, Employee e")
	List<DeptEmpDto> fetchEmpDeptDataCrossJoin();


	
   // Optional<Employee> findByCompanyIdAndEmployeeNumber(Long companyId,Long employeeNumber);
    
//	Optional<Employee> findByEmpID(Long empId);
}