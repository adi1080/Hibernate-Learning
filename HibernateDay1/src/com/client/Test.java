package com.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.HibernateUtil;
import com.model.Student;

public class Test {
public static void main(String[] args) {
	
	Student s=new Student();
	s.setRollno(1);
	s.setName("XYZ");
	s.setMobileno(1234567);
	
	//create object of session factory
	SessionFactory sf = HibernateUtil.getSessionFactory();   //import hibernate session factory 
	                                                          //as these are multiple imports
	//create object of session
	Session session = sf.openSession();           //import hibernate session...
	//session.persist(s);  //persist used instead of save since version 5
	
	int rollno = (int) session.save(s);//has return type unlike persist 
	System.out.println(rollno);
	
	session.beginTransaction().commit();
	
}
}
