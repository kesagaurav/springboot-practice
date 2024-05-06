package com.gaurav.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.exceptions.EmployeeException;
import com.gaurav.model.Employee;
import com.gaurav.repository.EmpoyeeRepository;
import com.gaurav.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmpoyeeRepository eRepo;
	
	@Override
	public Employee create(Employee e) {
		// TODO Auto-generated method stub
		return eRepo.save(e);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return eRepo.findAll();
	}

	@Override
	public Optional<Employee> getById(Employee e) throws EmployeeException  {
		// TODO Auto-generated method stub
		Optional<Employee> e1=eRepo.findById(e.getEid());
		e1.orElseThrow(()-> new EmployeeException("id is not found " + e.getEid()));
		return e1;
	}

	@Override
	public void delete(int id)throws EmployeeException  {
		Employee e1=eRepo.findById(id).orElseThrow(()-> new EmployeeException("id is not found + " + id));
		
		 eRepo.delete(e1);
	}

}
