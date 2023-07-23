package com.malunjkar.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	static {
		try {
			Configuration  configuration= new Configuration();
			configuration.configure("/com/malunjkar/resources/hibernate.cfg.xml");
			System.out.println("Hi"+"--------------");
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(configuration.getProperties());
			StandardServiceRegistry serviceRegistry = builder.build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	private HibernateUtil() {}
}
