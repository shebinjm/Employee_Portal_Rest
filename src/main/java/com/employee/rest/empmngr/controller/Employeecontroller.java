package com.employee.rest.empmngr.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.rest.empmngr.model.Employee;
import com.employee.rest.empmngr.service.Employeeservice;

@CrossOrigin("*")
@RestController
@RequestMapping(value= "/employee")
public class Employeecontroller {

	@Autowired
	Employeeservice employeeService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method to save employee.
	 * @param emp
	 * @return
	 */
	@PostMapping(value= "/create")
	public String create(@RequestBody Employee emp) {
		logger.debug("Saving employees.");
		employeeService.createEmployee(emp);
		return "Employee records created.";
	}

	/**
	 * Method to fetch all employees from Db.
	 * @return
	 */
	@GetMapping(value= "/getall")
	public Collection<Employee> getAll() {
		logger.debug("Getting all employees.");
		return employeeService.getAllEmployees();
	}

	/**
	 * Method to fetch employee by id.
	 * @param id
	 * @return
	 */
	@GetMapping(value= "/getbyid/{employee-id}")
	public Optional<Employee> getById(@PathVariable(value= "employee-id") int id) {
		logger.debug("Getting employee with employee-id= {}.", id);
		return employeeService.findEmployeeById(id);
	}

	/**
	 * Method to update employee by id.
	 * @param id
	 * @return
	 */
	@PutMapping(value= "/update/{employee-id}")
	public String update(@PathVariable(value= "employee-id") int id, @RequestBody Employee e) {
		logger.debug("Updating employee with employee-id= {}.", id);
		e.setEmpId(id);
		employeeService.updateEmployee(e);
		return "Employee record for employee-id= " + id + " updated.";
	}

	/**
	 * Method to delete employee by id.
	 * @param id
	 * @return
	 */
	@DeleteMapping(value= "/delete/{employee-id}")
	public String delete(@PathVariable(value= "employee-id") int id) {
		logger.debug("Deleting employee with employee-id= {}.", id);
		employeeService.deleteEmployeeById(id);
		return "Employee record for employee-id= " + id + " deleted.";
	}

	/**
	 * Method to delete all employees from the db.
	 * @return
	 */
	@DeleteMapping(value= "/deleteall")
	public String deleteAll() {
		logger.debug("Deleting all employees.");
		employeeService.deleteAllEmployees();
		return "All employee records deleted.";
	}
}