package com.harold.springboot.cruddemo.dao;

import java.util.List;

import com.harold.springboot.cruddemo.entity.Employee;

public interface EmployeeDao {

	List<Employee> findAll();
	Employee findById(int id);
	void save(Employee employee);
	void deleteById(int id);
}
