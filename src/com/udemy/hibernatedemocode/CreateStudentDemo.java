package com.udemy.hibernatedemocode;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernatedemo.entity.Student;

public class CreateStudentDemo {

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
			String theDateOfBirthStr = "21/12/1994";
			Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			Student tempStudent = new Student("Forsythe","Jones","jonesf1@gmail.com",theDateOfBirth);
			// start a transaction			
			session.beginTransaction();
			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
