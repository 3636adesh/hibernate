package com.malunjkar.test;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.malunjkar.entity.Employee;

public class Test {

	public static void main(String[] args) throws Exception {
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			configuration = new Configuration();
			configuration.configure("com/malunjkar/resources/mycfg.xml");
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
//			Employee employee = (Employee) session.get(Employee.class, 222);  //eager loading direct interact with database
			System.out.println("Before calling load()");
			Employee employee = (Employee) session.load(Employee.class, 111); //lazy loading when it use that time interact with database
//			System.out.println(employee.getEno());                            //creating proxy object in that primary key store and when we use that time load db-object.
			System.out.println("After calling load()");
//			System.out.println(employee);
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
