package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class CreateStudentDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// save object
			Student student = new Student("Harold", "YEO", "hy@email.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			System.out.println("DONE!");
			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
	}

}
