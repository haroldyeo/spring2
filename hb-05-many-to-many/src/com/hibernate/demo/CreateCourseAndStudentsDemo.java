package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;

public class CreateCourseAndStudentsDemo {
	
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
			
			// create a course
			Course newCourse = new Course("PACMAN guide");
			
			
			
			System.out.println("Course: " + newCourse);
			System.out.println("Reviews: " + newCourse.getReviews());
			
			// save the course
			System.out.println("Saving course");
			session.save(newCourse);
			
			// create students
			Student s1 = new Student("John", "Doe", "jd@udemy.org");
			Student s2 = new Student("Mary", "Public", "mp@udemy.org");
						
			// add them to the course
			newCourse.addStudent(s1);
			newCourse.addStudent(s2);
			
			// save the students
			System.out.println("Saving students");
			session.save(s1);
			session.save(s2);
			
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
