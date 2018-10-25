package com.justClick.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.justClick.api.domain.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
	public Employee findByName(String name);
	public List<Employee> findAll();
}
