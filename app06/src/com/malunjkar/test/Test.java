package com.malunjkar.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.malunjkar.enitity.Employee;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
//			Configuration cfg = new AnnotationConfiguration();
			Configuration cfg = new Configuration();
			cfg.configure("com/malunjkar/resources/hibernate.cfg.xml");
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Employee employee = new Employee();
			employee.setEno(666);
			employee.setEname("Yash");
			employee.setEsal(2000);
			employee.setEadd("Pune");
			int eno = (int) session.save(employee);
			if (eno == 555)
				System.out.println("Employee saved");
			else
				System.out.println("Employee not save");
			tx.commit();
		} catch (Exception e) {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
			e.printStackTrace();
		}

	}
}
