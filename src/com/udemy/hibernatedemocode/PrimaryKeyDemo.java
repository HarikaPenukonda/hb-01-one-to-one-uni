package com.udemy.hibernatedemocode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernatedemo.entity.Student;

public class PrimaryKeyDemo {

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
					// create 3 student objects
//					Student tempStudent1 = new Student("Archie","Andrews","andrewsa1@gmail.com");
//					Student tempStudent2 = new Student("Betty","Cooper","cooperb1@gmail.com");
//					Student tempStudent3 = new Student("Forsythe","Jones","jonesf1@gmail.com");
//					Student tempStudent4 = new Student("Veronica","lodge","lodgev1@gmail.com");
					// start a transaction			
					session.beginTransaction();
					// save the student object
					System.out.println("Saving the student...");
//					session.save(tempStudent1);
//					session.save(tempStudent2);
//					session.save(tempStudent3);
//					session.save(tempStudent4);
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
					
				}finally {
					factory.close();
				}
	}

}
