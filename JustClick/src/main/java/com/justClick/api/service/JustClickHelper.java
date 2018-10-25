package com.justClick.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.justClick.api.domain.Employee;
import com.justClick.api.domain.ResponseStructure;
import com.justClick.api.gateway.AbstractExternalGateway;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class JustClickHelper extends AbstractExternalGateway<ResponseStructure>{
	
	@Autowired
	private FetchEmployeeService fetchEmployeeService;
	
	@Value("${backend.url}")
	private String backendUrl;
	
	public Employee getEmployeeDetails(String name) {
		
		try {
			Employee employee = fetchEmployeeService.findByName(name);
			List<Employee> employee2 = fetchEmployeeService.findAll();
			
			return employee;
		} catch (Exception ex){
			log.info(ex.getMessage());
			return null;			
		}
		
	}

	@Override
	public Object parseResponse(Object response) {
		// TODO Auto-generated method stub
		return response;
	}

	@Override
	public HttpHeaders createHeaders(Object... body) {
		// TODO Auto-generated method stub
		return null;
	}

}
