package com.udemy.hibernatedemocode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernatedemo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int StudentId = 2;
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id : primary key
			System.out.println("\nGetting student id " + StudentId);
			
			Student myStudent = session.get(Student.class, StudentId);
			
			System.out.println("Updating student...");
			myStudent.setEmail("andrewsa1@gmail.com");
		
			// commit the transaction
			session.getTransaction().commit();
			
			// new code
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all students
			session.createQuery("update Student s set s.email='abc@gmail.com' where s.email LIKE '%@yahoo.com' ")
				.executeUpdate();
			
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
						
			
			
		}finally {
			factory.close();
		}
	}

}
