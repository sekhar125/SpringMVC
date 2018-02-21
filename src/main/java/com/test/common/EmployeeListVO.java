package com.test.common;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
public class EmployeeListVO {
	
	
	
	public EmployeeListVO() {
	}

	@JsonIgnoreProperties("employees")
	List<EmployeeVO> employees=new ArrayList<EmployeeVO>();

	public List<EmployeeVO> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeVO> employees) {
		this.employees = employees;
	}
}
