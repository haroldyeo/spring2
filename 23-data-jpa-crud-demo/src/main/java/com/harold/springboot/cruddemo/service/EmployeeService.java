package com.harold.springboot.cruddemo.service;

import java.util.List;

import com.harold.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	void save(Employee employee);
	Employee findById(int id);
	void deleteById(int id);

}
