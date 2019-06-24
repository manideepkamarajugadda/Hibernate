package mani.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mani.spring.hibernate.entity.Student;

public class PrimaryKeyTest {

	public static void main(String[] args) {
		//Create Session Factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				//Create Session
				Session session =factory.getCurrentSession();
				
				try {
					
					//Create 3 student objects
					System.out.println("----Creating 3 Student objects-----");
					Student tempStudent1 = new Student("sandeep","alla","asndp@gmail.com");
					Student tempStudent2 = new Student("arun","v","varun@gmail.com");
					Student tempStudent3 = new Student("varun","t","tvarun@gmail.com");
					
					//begin transaction
					session.beginTransaction();
					
					//save student object
					System.out.println("-----Saving the Student----");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);

					//commit transaction
					session.getTransaction().commit();
				
					System.out.println("Student Objects Save Complete");
					
				}
				finally
				{
					factory.close();
				}
				
				

	}

}
