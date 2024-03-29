package mani.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mani.spring.hibernate.entity.Student;

public class DeleteStudentTest {

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
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on id: primary key
			System.out.println("\nGetting student with id : "+ studentId);
		
			Student myStudent= session.get(Student.class, studentId);
		
			//delete the student
			//session.delete(myStudent);
			
			//delete student id=2
			
			System.out.println("Deleting Student with id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();

			System.out.println("Done");
			
		}
		finally
		{
			factory.close();
		}
		
		
		
	}

}
