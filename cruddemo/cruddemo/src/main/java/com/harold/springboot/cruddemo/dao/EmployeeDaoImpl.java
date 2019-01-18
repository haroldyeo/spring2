package com.harold.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harold.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	// entity manager
	private EntityManager entityManager;
	
	// constructor injection
	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager; 
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> q = currentSession.createQuery("from Employee", Employee.class); 
		List<Employee> list = q.getResultList();
		return list;
	}

}
