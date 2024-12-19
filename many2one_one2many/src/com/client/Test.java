package com.client;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.config.HibernateUtil;
import com.model.Department;
import com.model.Employee;


public class Test {
public static void main(String[] args) {
	Session session=HibernateUtil.getSessionFactory().openSession();
	
	Department d1=new Department();
	d1.setDid(101);
	d1.setdName("HR");
	
	Employee e1=new Employee();
	e1.setEid(1);
	e1.setEname("ABC");
	e1.setD(d1);
	
	Employee e2=new Employee();
	e2.setEid(2);
	e2.setEname("XYZ");
	e2.setD(d1);
	
	d1.getE().add(e1);
	d1.getE().add(e2);
	session.save(d1);
	session.beginTransaction().commit();
}
}
