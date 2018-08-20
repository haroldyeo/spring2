package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;

public class DeleteMaryDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// save object
			session.beginTransaction();
			
			// get Mary from DB
			int maryId = 2;
			Student mary = session.get(Student.class, maryId);
			System.out.println(mary);
			System.out.println(mary.getCourses());
			
			// delete Mary
			System.out.println("Deleting Mary");
			session.delete(mary);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
		} catch (Exception e) {
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
