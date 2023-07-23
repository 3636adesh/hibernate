package com.malunjkar.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory =null;
		Session session =null;
		try {
            Configuration cfg= new Configuration();
            cfg.configure();
           StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();              // creating hbn evn in 4.x version
           builder=builder.applySettings(cfg.getProperties());
           StandardServiceRegistry standardServiceRegistry = builder.build();
           sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
           session = sessionFactory.openSession();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
