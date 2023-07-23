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
			//Query query = session.createQuery("from Employee");
			/*
			 * List<Employee> emps = query.list(); 
			 * emps.forEach(System.out::println);
			 */
			/*
			 * Iterator<Employee> emps = query.iterate(); while(emps.hasNext())
			 * System.out.println(emps.next());
			 */
			/*
			ScrollableResults results = query.scroll();
			while(results.next()) {
				Object[] objects = results.get();
				for(Object object : objects) {
					Employee employee = (Employee) object;
					System.out.println(employee);
				}
			}
			while(results.previous()) {
				Object[] objects = results.get();
				for(Object object : objects) {
					Employee employee = (Employee) object;
					System.out.println(employee);
				}
			} */
			/*
			Employee employee = (Employee)query.uniqueResult();
			System.out.println(employee);
			*/
			tx=session.beginTransaction();
			/*
			Query query = session.createQuery("update Employee set esal = esal + 5000 where eno = 1");
			int rowcounts=query.executeUpdate();
			System.out.println(rowcounts);
			*/
			Query query = session.createQuery(" delete from Employee where eno = 12");
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
