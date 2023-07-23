package com.malunjkar.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.malunjkar.entity.Account;
import com.malunjkar.entity.Employee;

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
			builder.applySettings(configuration.getProperties());
			StandardServiceRegistry registry = builder.build();
			sessionFactory = configuration.buildSessionFactory(registry);
			session = sessionFactory.openSession();
			tx = session.getTransaction();
			tx.begin();
			
			Account account  = new Account();
			account.setAccno("2423");
			account.setAcctype("Saving");
			account.setBalance(453264536);
			
			Employee employee = new Employee();
			employee.setEno(111);
			employee.setEadd("Mumbai");
			employee.setEname("BBB");
			employee.setEsal(5500);
			employee.setAccount(account);
			
			int eno=(int) session.save(employee);
			System.out.println(eno+":- Employee Saved");
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
