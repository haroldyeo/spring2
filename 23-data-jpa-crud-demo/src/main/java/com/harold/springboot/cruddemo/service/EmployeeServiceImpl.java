package com.harold.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harold.springboot.cruddemo.dao.EmployeeRepository;
import com.harold.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		Employee theEmp = null;
		if(result.isPresent()) {
			theEmp = result.get();
		} else {
			throw new RuntimeException("Employee of id "+ id + " not found!");
		}
		return theEmp;
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

}
