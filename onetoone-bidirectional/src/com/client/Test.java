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
	
	//important
	p.setAd(ad);
	ad.setP(p);
	
	//session.save(p);         persist can also be used
	session.save(ad);   //it also saves person information and vise versa
	
	session.beginTransaction().commit();
	
}
}
