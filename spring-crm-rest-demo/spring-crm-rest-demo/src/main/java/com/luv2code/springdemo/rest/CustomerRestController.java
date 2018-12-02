package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {
		
		Customer theCust = customerService.getCustomer(customerId);
		if(theCust==null)
			throw new CustomerNotFoundException("Customer not found - "+customerId);
		
		return theCust;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCust) {
		theCust.setId(0);
		customerService.saveCustomer(theCust);
		return theCust;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCust) {
		customerService.saveCustomer(theCust);
		return theCust;
	}
	
	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id) {
		// check if customer exist
		if(getCustomerById(id) == null)
			throw new CustomerNotFoundException("Customer not found - "+id);
		
		customerService.deleteCustomer(id);
		return "Deleted Custoler with id: "+id;
	}

}
