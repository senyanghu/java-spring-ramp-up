package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {
			// create a student object
			System.out.println("Creating new student object");
			Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student");
			session.save(tempStudent);

			// commit transaction
			session.getTransaction().commit();

			// find out the student id: PK
			System.out.println("Saved student id: " + tempStudent.getId());

			// get a new session
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: PK
			Student myStudent = session.get(Student.class, tempStudent.getId());

			System.out.println("Get complete: " + myStudent);

			session.getTransaction().commit();

			System.out.println("Done!");
		}

		finally {
			factory.close();
		}

	}

}
