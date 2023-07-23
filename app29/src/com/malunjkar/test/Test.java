package com.malunjkar.test;

import java.util.List;

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
		Transaction tx = null;
		try {
			configuration = new Configuration();
			configuration.configure("/com/malunjkar/resources/hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(configuration.getProperties());
			StandardServiceRegistry serviceRegistry = builder.build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
		//	Query query = session.createQuery("select e.eno, e.ename,e.eadd,e.esal from Employee1 e where e.esal < ? ");
		//	query.setParameter(0, 1000000.00);
			Query query = session.createQuery("select e.eno, e.ename,e.eadd,e.esal from Employee1 e where e.esal < :salary ");
			query.setDouble("salary",100000);
			List<Object[]> list = query.list();
			for (Object[] objs : list) {
				for (Object obj : objs)
					System.out.print(obj+"\t");
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
		}

	}
}
