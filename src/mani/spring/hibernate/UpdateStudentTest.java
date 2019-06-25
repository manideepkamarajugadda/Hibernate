package mani.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mani.spring.hibernate.entity.Student;

public class UpdateStudentTest {

	public static void main(String[] args) {

		
		//Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//Create Session
		Session session =factory.getCurrentSession();
		
		try {
		
			int studentId=1;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nGetting student with id : "+ studentId);
		
			Student myStudent= session.get(Student.class, studentId);
		
			
			System.out.println("Updating Student");
			myStudent.setFirstName("Scooby");
			
			session.getTransaction().commit();
			
			
			//begin transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students
			System.out.println("update email for all students");
			
			session.createQuery("update Student set email='test@gmail.com'")
			.executeUpdate();
			
			
			
			//commit transaction
			session.getTransaction().commit();
			
			
			
			System.out.println("Done");
			
		}
		finally
		{
			factory.close();
		}
		
		
		
	}

}
