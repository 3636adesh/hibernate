package com.malunjkar.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("/com/malunjkar/resources/hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
