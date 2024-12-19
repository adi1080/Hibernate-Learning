package com.client;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.config.HibernateUtil;
import com.model.Student;



public class Test_parameters {
public static void main(String[] args) {
	
	Session session=HibernateUtil.getSessionFactory().openSession();
	
//	String hql="from Student where rollno=?1"; //positional parameter(?indexvalue)
//	String hql="from Student where rollno=:id"; //named parameter(:name)
	String hql="delete from Student where rollno=:id";
	
//	Query<Student> query=session.createQuery(hql,Student.class); //student.class needed in order to get data
	Query<Student> query=session.createQuery(hql);//no need to give class type for delete and update
	
	
	//query.setParameter(1, 9); //shows data of rollno 9 if present in database
    query.setParameter("id", 9);
	
	Transaction tx=session.beginTransaction();
	query.executeUpdate();
	tx.commit();
	
	//Student s=query.getSingleResult();
	//System.out.println(s);
}
}
