package com.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.HibernateUtil;
import com.model.Course;
import com.model.Student;

public class Test {
public static void main(String[] args) {
	SessionFactory sf=HibernateUtil.getSessionFactory();
	Session session=sf.openSession();
	
	Student A=new Student();
	A.setRollno(1);
	A.setName("XYZ");
	A.setMobileno(1234567);
	
	Student B=new Student();
	B.setRollno(2);
	B.setName("ABC");
	B.setMobileno(7654321);
	
	Course JAVA =new Course();
	JAVA.setCid(101);
	JAVA.setcName("JAVA");
	
	Course python=new Course();
	python.setCid(102);
	python.setcName("python");
	
	A.getC().add(JAVA);
	A.getC().add(python);
	B.getC().add(python);
	
	python.getS().add(A);
	python.getS().add(B);
	
	session.save(A);
	session.save(B);
	session.beginTransaction().commit();
	
}
}
