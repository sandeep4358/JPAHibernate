package com.example.JPAjoinPactice001.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptEmpDto {

	private String empDept;
	private String empName;
	private String empEmail;
	private String empAddress;
}

