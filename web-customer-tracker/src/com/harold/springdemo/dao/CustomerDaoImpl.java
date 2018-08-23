package com.harold.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harold.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	// need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get hibernate session
		Session session = sessionFactory.getCurrentSession();

		// get query
		Query<Customer> theQuery = session.createQuery("from Customer", Customer.class);

		// execute and get result
		List<Customer> customers = theQuery.getResultList();

		// return results
		return customers;
	}

}
