package com.harold.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harold.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {

	private EntityManager entityManager; 
	
	@Autowired
	public EmployeeDaoJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		Query q = entityManager.createQuery("from Employee"); 
		List<Employee> list = q.getResultList();
		return list;
	}

	@Override
	public Employee findById(int id) {
		return null;
	}

	@Override
	public void save(Employee employee) {

	}

	@Override
	public void deleteById(int id) {

	}

}
