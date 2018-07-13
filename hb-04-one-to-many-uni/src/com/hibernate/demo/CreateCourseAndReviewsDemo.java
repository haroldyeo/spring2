package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Review;

public class CreateCourseAndReviewsDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// save object
			session.beginTransaction();
			
			// create a course
			Course newCourse = new Course("PACMAN guide");
			
			// add some reviews
			newCourse.addReview(new Review("Great book"));
			newCourse.addReview(new Review("It kinda sucks"));
			
			System.out.println("Course: " + newCourse);
			System.out.println("Reviews: " + newCourse.getReviews());
			
			// save the course
			System.out.println("Saving course and reviews");
			session.save(newCourse);
			
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
