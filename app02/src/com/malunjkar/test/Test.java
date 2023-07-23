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
			configuration.configure();
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.getTransaction();
			transaction.begin();
			Employee employee = new Employee();
			employee.setEno(111);
			employee.setEname("CCC");
			employee.setEaddress("Jaipur");
			employee.setEsal(5000d);
//			session.update(employee);
			session.saveOrUpdate(employee);
			transaction.commit();
			System.out.println("Insert/update employee successfully.");
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("Employee not Inserted/updated.");
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
		}

	}
}
