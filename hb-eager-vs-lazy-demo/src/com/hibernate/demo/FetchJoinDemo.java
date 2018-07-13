package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class FetchJoinDemo {
	
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
			
			session.beginTransaction();
			
			int theId = 1;

			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+ " JOIN FETCH i.courses"
					+ " where i.id =: theInstructorId", Instructor.class);
			
			// set parameter
			query.setParameter("theInstructorId", theId);
			
			Instructor instructorTemp = query.getSingleResult();
			
			System.out.println("harold test: " + instructorTemp);
			
			List<Course> courses = instructorTemp.getCourses();
			
			System.out.println("harold test: " + courses);
			
			
			session.getTransaction().commit();
			System.out.println("harold test: " + "DONE!");
			
			session.close();
			System.out.println("The sesison is now closed");
			
			
			
		} catch (Exception e) {
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
