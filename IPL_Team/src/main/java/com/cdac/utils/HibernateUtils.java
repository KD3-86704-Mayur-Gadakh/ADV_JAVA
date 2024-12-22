package com.cdac.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sessionFactory;

	

	
	static {
		System.out.println("static  block");
		
		sessionFactory=  new Configuration().configure().buildSessionFactory();
		
	}
	
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	
	

}
