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
		Query<Customer> theQuery = session.createQuery("from Customer order by lastName", Customer.class);

		// execute and get result
		List<Customer> customers = theQuery.getResultList();

		// return results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get hibernate session
			Session session = sessionFactory.getCurrentSession();
			try {
				// Save customer
				session.saveOrUpdate(theCustomer);	
			} catch (Exception e) {
				System.out.println("An error has occured " + e.getStackTrace());
			}
		
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> q = session.createQuery("delete from Customer where id=:custId");
		q.setParameter("custId", id);
		q.executeUpdate();
	}

}
