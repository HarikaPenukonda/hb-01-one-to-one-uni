package com.udemy.hibernatedemocode;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernatedemo.entity.Student;

public class QueryDemoStudent {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction			
			session.beginTransaction();
			
			// query the students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			// query students : lastname='cooper'
			theStudents = session.createQuery("from Student s where s.lastName='Cooper'").getResultList();
			
			// display the students
			System.out.println("\n\nstudents whose last name is Cooper");
			displayStudents(theStudents);
			
			// query Students : lastname : Cooper or firstname : Amy
			theStudents = 
					session.createQuery("from Student s where "
							+ "s.lastName='Cooper' OR s.firstName='Amy'").getResultList();
			System.out.println("\nStudents who have lastname : Cooper or firstname : Amy ");
			displayStudents(theStudents);
			
			// Query Students : where email LIKE @gmail.com
			theStudents = session.createQuery("from Student s where "
					+"s.email LIKE '%@gmail.com'").getResultList();
			System.out.println("\n\nstudents whose email ends with @gmail.com ");
			displayStudents(theStudents);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
