package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class CreateInstructorDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// save object
			session.beginTransaction();
			
			// get instructor from DB
			int theId = 1;
			Instructor tempInstr = session.get(Instructor.class, theId);
			
			// create courses
			Course c1 = new Course("Maths 101");
			Course c2 = new Course("CS 101");
			
			// assignement
			tempInstr.addCourse(c1);
			tempInstr.addCourse(c2);
			
			// save
			session.save(c1);
			session.save(c2);
			
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
		} catch (Exception e) {
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
