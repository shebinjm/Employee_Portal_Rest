package com.employee.rest.empmngr.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.employee.rest.empmngr.model.Employee;

public interface Employeeservice {

	/**
	 * Method to create new employee in the db with mongodb repository.
	 * @param emp
	 */
	public void createEmployee(Employee emp);

	/**
	 * Method to fetch all employees from the db with mongodb repository.
	 * @return
	 */
	public Collection<Employee> getAllEmployees();

	/**
	 * Method to fetch employee by id with mongoDb repository.
	 * @param id
	 * @return
	 */
	public Optional<Employee> findEmployeeById(int id);

	/**
	 * Method to delete employee by id with mongodb repository.
	 * @param id
	 */
	public void deleteEmployeeById(int id);

	/**
	 * Method to update employee by id with mongodb repository.
	 * @param id
	 */
	public void updateEmployee(Employee emp);

	/**
	 * Method to delete all employees with mongodb repository.
	 */
	public void deleteAllEmployees();
}