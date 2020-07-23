package com.udemy.hibernatedemocode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernatedemo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// use the session object to save java object
			System.out.println("Creating new student object...");
			// create a student object
			//Student tempStudent = new Student("Amy","Santiago","santiagoa1@gmail.com");
			// start a transaction			
			session.beginTransaction();
			// save the student object
			System.out.println("Saving the student...");
//			System.out.println(tempStudent);
//			session.save(tempStudent);
			// commit transaction
			session.getTransaction().commit();
			
			// find out the student's id primary key
			//System.out.println("Saved Student Generated id: " + tempStudent.getId());
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			// retrieve student based on the id : primary key
//			System.out.println("\nGetting student id " + tempStudent.getId());
//			Student myStudent = session.get(Student.class, tempStudent.getId());
			//System.out.println("get complete info " +myStudent);
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			
			
			
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
	}

}
