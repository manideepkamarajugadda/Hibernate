package mani.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mani.spring.hibernate.entity.Student;

public class ReadStudentTest {

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
			Student tempStudent = new Student("hero","zero","herozero@gmail.com");
			
			//begin transaction
			session.beginTransaction();
			
			//save student object
			System.out.println("-----Saving the Student----");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			
			//find out the students id : primary key
			
			System.out.println("Saved Student. Generated id: "+tempStudent.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nGetting student with id : "+ tempStudent.getId());
		
			Student myStudent= session.get(Student.class, tempStudent.getId());
		
			
			System.out.println("Get Complete: "+ myStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally
		{
			factory.close();
		}
		
		
		
	}

}
