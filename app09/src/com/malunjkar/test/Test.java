package com.malunjkar.test;

import java.io.IOException;
import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.malunjkar.enitity.Employee;

public class Test {

	public static void main(String[] args) throws IOException {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx =null;
		try {
			Configuration cfg = new Configuration();
			cfg.configure();
			sessionFactory = cfg.buildSessionFactory();
			 session=sessionFactory.openSession();
			 tx = session.beginTransaction();
				Employee employee = new Employee();
				employee.setEno(2);
				employee.setEname("BBB");
				employee.setEsal(2000);
				employee.setEadd("Pune");
				session.save(employee);
				tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		}finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
		}
	}
}
