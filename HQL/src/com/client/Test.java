package com.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.config.HibernateUtil;
import com.model.Student;

public class Test {
public static void main(String[] args) {
	
	//step - 1
	Session session=HibernateUtil.getSessionFactory().openSession();
	
	//step - 2
	String hql="from Student";  //used instead select*from -> retrieves all data
    
	//step - 3
	Query<Student> query=session.createQuery(hql,Student.class);
	
	//Student s = query.getSingleResult(); //used to retrieve single data from database
	
	//step - 4
	List<Student> list=query.getResultList();//used to retrieve list
	list.forEach((s)->{
//		System.out.println(s.getRollno());
//		System.out.println(s.getName());             //used to retrieve multiple data
//		System.out.println(s.getMobileno());
	    System.out.println(s); //with toString()
		
	});
}
}
