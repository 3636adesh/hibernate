package com.malunjkar.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) throws Exception {
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx =null;
		try {
			configuration = new Configuration();
			configuration.configure("/com/malunjkar/resources/hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(configuration.getProperties());
			StandardServiceRegistry serviceRegistry = builder.build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			session = sessionFactory.openSession();
			tx=session.beginTransaction();
			Query query = session.createQuery("insert into Employee2 (eno,ename,eadd,esal) select e.eno,e.ename,e.eadd,e.esal from Employee1 e");
			int rowcounts=query.executeUpdate();
			System.out.println(rowcounts);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
		}

	}
}
