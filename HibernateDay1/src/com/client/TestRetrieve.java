package com.client;

import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.Student;

public class TestRetrieve {
public static void main(String[] args) {
	
	Session se=HibernateUtil.getSessionFactory().openSession();
	
	
//	s.setRollno(9);
//	s.setName("ABC");
//	s.setMobileno(7654321);
//	se.save(s);
	
	//Student s=se.load(Student.class, 9);
	Student s=se.get(Student.class, 9);
	System.out.println(s.getRollno());
	System.out.println(s.getName());
	se.beginTransaction().commit();
	
}
}
