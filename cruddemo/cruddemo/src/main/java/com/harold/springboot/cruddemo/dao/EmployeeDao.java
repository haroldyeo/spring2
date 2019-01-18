package com.harold.springboot.cruddemo.dao;

import java.util.List;

import com.harold.springboot.cruddemo.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
}
