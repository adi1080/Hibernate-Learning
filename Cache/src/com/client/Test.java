package com.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.config.HibernateUtil;         //lvl 2 cache -> hits database only once even for 2 sessions
import com.model.Student;                // to enable it - 3 lines of code in hibernateutil , @cache 
                                         //annotation in entity class , add external jars        

public class Test {
public static void main(String[] args) {
	
	Session se=HibernateUtil.getSessionFactory().openSession();
	
	Student s1=se.get(Student.class, 1);
	//se.clear(); //clears all stored data in cache so with this database is hit 3 times
	Student s2=se.get(Student.class, 1);
	Student s3=se.get(Student.class, 1);                                
	
	Session se2=HibernateUtil.getSessionFactory().openSession();
	
	Student s4=se2.get(Student.class, 1);
}
}
//with lvl 1 cache only 2 times hit the database as separate cache is created for every session
//and only available for that session