package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class UpdateStudentDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int studentId = 1;
			Student myStudent = session.get(Student.class, studentId);
			myStudent.setFirstName("Karamoko");
			session.getTransaction().commit();
			
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email = 'foo.gmail.com'").executeUpdate();			
			session.getTransaction().commit();
			
			
			System.out.println("DONE!");
			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
	}

}
