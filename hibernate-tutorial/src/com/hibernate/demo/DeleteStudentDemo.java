package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class DeleteStudentDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {

			int studentId = 3;
			Student myStudent = session.get(Student.class, studentId);
			session.delete(myStudent);
			session.getTransaction().commit();
			
			
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			session.createQuery("delete from Student s where s.id=3000").executeUpdate();			
//			session.getTransaction().commit();
			
			
			System.out.println("DONE!");
			
		} catch (Exception e) {
			
		} finally {
		}
	}

}
