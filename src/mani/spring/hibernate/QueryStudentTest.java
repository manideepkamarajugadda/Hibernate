package mani.spring.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mani.spring.hibernate.entity.Student;

public class QueryStudentTest {

	public static void main(String[] args) {

		
		//Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//Create Session
		Session session =factory.getCurrentSession();
		
		try {
			
			//begin transaction
			session.beginTransaction();
			
			//query students
			
			List<Student> studentList = session.createQuery("from Student").getResultList();
							
			//display students
			displayStudents(studentList);
			
		  studentList = session.createQuery("from Student s where s.lastName='deep'").getResultList();
			displayStudents(studentList);
			
			System.out.println();
			System.out.println();
			System.out.println();
			  studentList = session.createQuery("from Student s where "+ "s.lastName='deep' OR s.firstName='arun'").getResultList();

				displayStudents(studentList);

				
				studentList = session.createQuery("from Student s where "+ "s.email LIKE '%gmail.com'").getResultList();
				displayStudents(studentList);

			//commit transaction
			session.getTransaction().commit();
		
			System.out.println("Done");
			
		}
		finally
		{
			factory.close();
		}
		
		
		
	}

	private static void displayStudents(List<Student> studentList) {
		for(Student tempStudent: studentList)
		{
			System.out.println(tempStudent);
		}
	}

}
