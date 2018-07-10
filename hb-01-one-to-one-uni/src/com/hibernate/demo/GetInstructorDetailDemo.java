package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Student;

public class GetInstructorDetailDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			// get the instruction detail object
			int theId = 15;
			InstructorDetail instrDet = session.get(InstructorDetail.class, theId);
			
			// print the details
			System.out.println(instrDet);
			
			// print the associated instructor			
			System.out.println(instrDet.getInstructor());
			
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
