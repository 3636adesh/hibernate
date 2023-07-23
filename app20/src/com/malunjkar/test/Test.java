package com.malunjkar.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.malunjkar.entity.Employee;

public class Test {

	public static void main(String[] args) throws Exception {
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			configuration = new Configuration();
			configuration.configure("/com/malunjkar/resources/hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder.applySettings(configuration.getProperties());
			StandardServiceRegistry registry = builder.build();
			sessionFactory = configuration.buildSessionFactory(registry);
			session = sessionFactory.openSession();
			Employee employee=(Employee)session.get(Employee.class, 111);
			System.out.println(employee);
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
		}

	}
}
