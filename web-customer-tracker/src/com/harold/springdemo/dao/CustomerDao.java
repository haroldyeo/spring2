package com.harold.springdemo.dao;

import java.util.List;

import com.harold.springdemo.entity.Customer;

public interface CustomerDao {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void delete(int id);
}
