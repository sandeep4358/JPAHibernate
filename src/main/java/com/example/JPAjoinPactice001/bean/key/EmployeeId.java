package com.example.JPAjoinPactice001.bean.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class EmployeeId implements Serializable {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "company_id")
	    private String companyNumber;
	    @Column(name = "employee_number")
		  private String employeeNumber;
}
