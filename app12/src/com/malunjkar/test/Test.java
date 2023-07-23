package com.malunjkar.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.malunjkar.entity.Account;
import com.malunjkar.entity.Address;
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
			Account account = new Account();
			account.setAccName("Saving");
			account.setAccType("SVG");
			account.setAccNo(1234534);
			Address address = new Address();
			address.setCity("pune");
			address.setPhone("63434989089");
			address.setStreet("GB Road");
			Employee employee = new Employee();
			employee.setEno(111);
			employee.setEadd("Mumbai");
			employee.setEname("BBB");
			employee.setEsal(5500);
			employee.setAddress(address);
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
