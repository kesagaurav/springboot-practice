package com.gaurav.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.exceptions.EmployeeException;
import com.gaurav.model.Employee;
import com.gaurav.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@PostMapping("/employee")
	public ResponseEntity<Employee> create(@RequestBody @Valid Employee e) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Employee>(service.create(e), HttpStatus.CREATED);
	}
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		// TODO Auto-generated method stub
		return new ResponseEntity<List<Employee>>(service.getAllEmployees(), HttpStatus.ACCEPTED);
	}
	@GetMapping("/employee/{id}")
	public ResponseEntity<Optional<Employee>> getById(@PathVariable int id) throws EmployeeException {
		// TODO Auto-generated method stub
		Employee e=new Employee();
		return new ResponseEntity<Optional<Employee>>(service.getById(e), HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) throws EmployeeException {
		// TODO Auto-generated method stub
		service.delete(id);
		return new ResponseEntity<String>("id is deleted "+ id, HttpStatus.GONE);
	}

}
