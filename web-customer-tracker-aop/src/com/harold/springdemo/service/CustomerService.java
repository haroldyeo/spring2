package com.harold.springdemo.service;

import java.util.List;

import com.harold.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void delete(int id);
}
