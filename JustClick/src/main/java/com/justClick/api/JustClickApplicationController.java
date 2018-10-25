package com.justClick.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.justClick.api.domain.Employee;
import com.justClick.api.service.JustClickHelper;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/jcc")
//@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class JustClickApplicationController {
	
	@Autowired
	JustClickHelper justClickHelper;
	
	 @Autowired
	 private Environment environment;
	
	@RequestMapping(value="/api", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<String> index(@RequestBody String input) {
		log.info("inside main controller");
		//Employee response = justClickHelper.getEmployeeDetails(name);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		
		try {
			JsonNode  node =  objectMapper.readTree(input);
			String value = node.at("/request/intent/slots/options/value").asText();
			System.out.println("value###############"+ value);
			Employee emp = new Employee();
			Method method = Employee.class.getMethod("setName", String.class);
			method.invoke(emp, value);
			System.out.println("Reflection Successfull###############"+ emp.getName());
			Properties pro = new Properties();
			FileInputStream in = new FileInputStream("application.properties");
			pro.load(in);
			pro.propertyNames();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<>("Done", HttpStatus.OK);
    }
	
}
