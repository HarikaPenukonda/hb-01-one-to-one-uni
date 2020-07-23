package com.udemy.hibernatedemocode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernatedemo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int StudentId = 1;
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id : primary key
			System.out.println("\nGetting student id " + StudentId);
			
			Student myStudent = session.get(Student.class, StudentId);
			
			// delete the student
			//System.out.println("Deleting Student:" +myStudent);
			//session.delete(myStudent);
		
			// alternate approach to delete
			System.out.println("Deleting student id=7");
			session.createQuery("delete from Student where id=7").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
	}

}
