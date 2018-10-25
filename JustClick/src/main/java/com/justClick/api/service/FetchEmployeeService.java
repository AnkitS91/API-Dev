package com.justClick.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justClick.api.domain.Employee;
import com.justClick.api.repository.EmployeeRepository;

@Service
public class FetchEmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee findByName(String name) {
		return employeeRepository.findByName(name);
	}
	
	public List<Employee> findAll() {
		return (List<Employee>) employeeRepository.findAll();
	}

}
