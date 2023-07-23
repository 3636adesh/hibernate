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
		Transaction transaction = null;
		try {
			configuration = new Configuration();
			configuration.configure("mycfg.xml");
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Employee employee = new Employee();
			employee.setEno(111);
			session.delete(employee);
			transaction.commit();
			System.out.println("Delete employee successfully.");
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("Employee not delete.");
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
		}

	}
}
