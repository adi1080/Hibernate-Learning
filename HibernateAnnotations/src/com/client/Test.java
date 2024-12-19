package com.client;

import java.util.Scanner;

import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.Employee;

public class Test {
public static void main(String[] args) {
	Session se = HibernateUtil.getSessionFactory().openSession();
	
	Scanner sc=new Scanner(System.in);
	
	Employee e = new Employee();
	System.out.println("Enter id , name , mobileno");
	 e.setId(sc.nextInt()); 
	 e.setName(sc.next());
	 sc.nextLine();
	 e.setMobileno(sc.nextLong());
	 
	 se.persist(e);
	 se.beginTransaction().commit();
	 se.close();
}
}
