package com.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.config.HibernateUtil;
import com.model.AdharCard;
import com.model.Person;


public class Test {
public static void main(String[] args) {
	Session session=HibernateUtil.getSessionFactory().openSession();
	
	AdharCard ad=new AdharCard();
	ad.setAid(1);
	ad.setAdharName("A");
	
	Person p=new Person();
	p.setPid(1);
	p.setPname("AB");
	p.setAd(ad);
	
	session.persist(p);  
	
	session.beginTransaction().commit();
	
}
}
