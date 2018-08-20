package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;

public class DeletePamanCourseDemo {
	
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
			
			// get the pacman course
			int pacManId = 10;
			Course pacmanCourse = session.get(Course.class,pacManId);
			
			//Delete the course
			System.out.println("deleting the couse");
			session.delete(pacmanCourse);
			
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
