package com.client;

import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.Student;

public class TestUpdate {
public static void main(String[] args) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	                   // 1st way of updating data
//	Student s=new Student();
//	s.setRollno(1);
//	s.setName("A");
//	s.setMobileno(7777777);
//	
//	session.update(s);
//	session.beginTransaction().commit();
	
	
	                         //  2nd way 
	Student s = session.get(Student.class, 1);   //rollno=1
	if(s!=null)
	{
		s.setName("D");
		session.update(s);
		session.beginTransaction().commit();
	}
	
	
}
}
