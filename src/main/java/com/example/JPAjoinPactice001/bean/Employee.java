package com.example.JPAjoinPactice001.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.JPAjoinPactice001.bean.key.EmployeeId;
import com.fasterxml.jackson.annotation.JsonIdentityReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Employee{

//	@Id
//	@Column(name = "empID")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long empID;
	
//	The @EmbeddedId is used to instruct Hibernate that the Employee entity uses a compound key.

	@EmbeddedId
    private EmployeeId employeeId;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_dept_id")
	//@JsonIgnore
    @JsonIdentityReference(alwaysAsId = true)
	private Department department;

	
	
}