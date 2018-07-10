package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Employee;

public class EmployeeApp {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create employees
		createNewEmployee(factory);	

		// get list employees by company
		printListEmployee(factory);
		
		// Update one employee
		
		
		
		// delete one employee
		
	}

	private static Session getSession(SessionFactory factory) {
			
		return factory.getCurrentSession();
	}

	private static void printListEmployee(SessionFactory factory) {
		
		Session session = getSession(factory);
		
		try {
			session.beginTransaction();
			List<Employee> list = session.createQuery("from Employee emp where emp.company = 'BBVA'").getResultList();
			list.forEach(emp -> System.out.println(emp.getFirstName() + " " + emp.getLastName() + " " + emp.getCompany()));
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		
		
	}

	private static void createNewEmployee(SessionFactory factory) {
		
		Session session = getSession(factory);	

		Employee emp = new Employee("Harold", "YEO", "ITAC");
		Employee emp2 = new Employee("Adam", "COULIBALY", "BBVA");
		Employee emp3 = new Employee("Etelle", "SORO", "SNDI");
		Employee emp4 = new Employee("Stevenson", "NG", "BBVA");
		Employee emp5 = new Employee("Jeremy", "NELSON", "BBVA");
		Employee emp6 = new Employee("Ruben", "ABOUA", "SNDI");
		
		
		try {

			session.beginTransaction();
			session.save(emp);
			session.save(emp2);
			session.save(emp3);
			session.save(emp4);
			session.save(emp5);
			session.save(emp6);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		
		
		
	}

}
