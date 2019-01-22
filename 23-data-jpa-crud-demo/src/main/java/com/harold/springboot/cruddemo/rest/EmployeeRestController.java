package com.harold.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harold.springboot.cruddemo.entity.Employee;
import com.harold.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService service;
	
	@Autowired
	public EmployeeRestController(EmployeeService service) {
		this.service = service;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		Employee theEmp = service.findById(employeeId);
		if(theEmp == null)
			throw new RuntimeException("Id not found");
		return theEmp;
	}
	
	@PostMapping("/employees")
	public Employee save(@RequestBody Employee employee) {
		employee.setId(0);
		service.save(employee);
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee employee) {
		service.save(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String delete(@PathVariable int employeeId) {
		Employee theEmp = service.findById(employeeId);
		if(theEmp == null)
			throw new RuntimeException("Id not found");
		service.deleteById(employeeId);
		return "Ok!";
	}

}
