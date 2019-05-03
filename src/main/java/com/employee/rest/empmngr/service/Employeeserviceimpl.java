package com.employee.rest.empmngr.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.rest.empmngr.repositories.EmployeeRepository;
import com.employee.rest.empmngr.exception.EntityNotFoundException;
import com.employee.rest.empmngr.model.Employee;

@Service
public class Employeeserviceimpl implements Employeeservice {

	@Autowired
	EmployeeRepository employeeRepository;


	@Override
	public void createEmployee(Employee emp) {
		employeeRepository.save(emp);
	}

	@Override
	public Collection<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findEmployeeById(int id) throws EntityNotFoundException {
		Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.equals(Optional.empty())) {
            throw new EntityNotFoundException(Employee.class, "id", ""+id);
        }
        return employee;
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
	}


	@Override
	public void updateEmployee(Employee emp) {
		employeeRepository.save(emp);
	}

	@Override
	public void deleteAllEmployees() {
		employeeRepository.deleteAll();
	}
}