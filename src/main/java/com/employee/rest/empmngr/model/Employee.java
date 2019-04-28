package com.employee.rest.empmngr.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// MongoDb Database Annotation.
@Document(collection= "employee")
public class Employee {

	@Id
	private int empId;
	private String name;
	private String designation;

	public Employee() {	}
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", designation=" + designation + "]";
	}
}