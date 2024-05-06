package com.gaurav.service;

import java.util.List;
import java.util.Optional;

import com.gaurav.exceptions.EmployeeException;
import com.gaurav.model.Employee;

public interface EmployeeService {

	 Employee create(Employee e);
	 List<Employee> getAllEmployees();
	 Optional<Employee> getById(Employee e) throws EmployeeException ;
	 void delete(int id)throws EmployeeException ;
	 
	
	
	
}
