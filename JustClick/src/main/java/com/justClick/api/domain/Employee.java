package com.justClick.api.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonSerialize
@JsonInclude(Include.NON_NULL)
//@Document(collection = "EmployeeRecord")
public class Employee {
	
	private String name;
	private String doj; 
	private String salary; 
    private int career_level;
    private String phone_number;
}
