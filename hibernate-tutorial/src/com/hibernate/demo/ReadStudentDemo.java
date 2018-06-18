package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class ReadStudentDemo {
	
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
			Student student = new Student("Daffy", "Duck", "hy@email.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
			System.out.println("Saved student id is : " + student.getId());
			
			// retrieve
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student sR = session.get(Student.class, student.getId());
			session.getTransaction().commit();
			System.out.println(sR);
			
			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
	}

}
