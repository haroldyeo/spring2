package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class QueryStudentDemo {
	
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
			
			// query students
			List<Student> list = session.createQuery("from Student").getResultList();
			
			// dislpay the students
			displayStudents(list);
			
			// find all student with last name as duck
			List<Student> listDuck = session.createQuery("from Student s where s.lastName = 'Duck'").getResultList();
			displayStudents(listDuck);
			
			// students whose firsname is duff or last name is yeo
			List<Student> listThree = session.createQuery("from Student s where s.lastName = 'YEO' OR s.firstName = 'Daffy'").getResultList();
			displayStudents(listThree);
			
			session.getTransaction().commit();
			
			
			System.out.println("DONE!");
			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
	}

	private static void displayStudents(List<Student> list) {
		for(Student student : list) {
			System.out.println(student);
		}
		
		System.out.println("----------------");
	}

}
