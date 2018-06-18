package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class PrimaryKeyDemo {
	
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// save object
			Student student1 = new Student("Estelle", "YEO", "ey@email.com");
			Student student2 = new Student("Elodie", "YEO", "ely@email.com");
			Student student3 = new Student("Delphine", "YEO", "dy@email.com");

			session.beginTransaction();
			
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			session.getTransaction().commit();
			System.out.println("DONE!");
			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
	}
}