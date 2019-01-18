package com.harold.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harold.springboot.cruddemo.dao.EmployeeDao;
import com.harold.springboot.cruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeDao dao;
	
	@Autowired
	public EmployeeRestController(EmployeeDao dao) {
		this.dao = dao;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return dao.findAll();
	}

}
