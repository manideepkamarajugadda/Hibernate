package mani.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mani.spring.hibernate.entity.Student;

public class CreateStudentApp {

	public static void main(String[] args) {

		
		//Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//Create Session
		Session session =factory.getCurrentSession();
		
		try {
			
			//Create student object
			System.out.println("----Creating new Student object-----");
			Student tempStudent = new Student("mani","deep","deep8mani@gmail.com");
			
			//begin transaction
			session.beginTransaction();
			
			//save student object
			System.out.println("-----Saving the Student----");
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
		
			System.out.println("Student Object Save Complete");
			
		}
		finally
		{
			factory.close();
		}
		
		
		
	}

}
