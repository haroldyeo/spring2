package com.harold.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

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
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> q = currentSession.createQuery("from Employee", Employee.class); 
		List<Employee> list = q.getResultList();
		return list;
	}

	@Override
	public Employee findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, id);
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> q = currentSession.createQuery("delete from Employee where id=:employeeId"); 	
		q.setParameter("employeeId", id);
		q.executeUpdate();
	}

}
