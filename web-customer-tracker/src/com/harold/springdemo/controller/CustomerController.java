package com.harold.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harold.springdemo.entity.Customer;
import com.harold.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "list-customer";
	}
	
	@GetMapping("/showFormForAdd")
	public String showForm(Model model) {
		
		Customer theCustomer = new Customer();
		
		model.addAttribute("theCustomer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId")int id, Model theModel) {
		// get customer from DB
		Customer theCustomer = customerService.getCustomer(id);
		
		// add him to model Attribute
		theModel.addAttribute("theCustomer", theCustomer);
				
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deteteCustomer(@RequestParam("customerId") int id, Model model) {
		customerService.delete(id);
		return "redirect:/customer/list";
	}
	

}
