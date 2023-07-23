package com.malunjkar.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.malunjkar.entity.Customer;
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
			tx = session.beginTransaction();
			Customer customer = new Customer();
			customer.setCadd("Pune");
			customer.setCname("AA");
			customer.setpAdd("MUM");
			customer.setpName("Ravi");

			Employee employee = new Employee();
			employee.setEmpName("TTT");
			employee.setEmpSal(49875);
			employee.setpAdd("BBB");
			employee.setpName("XYZ");

			session.save(employee);
			session.save(customer);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
		}

	}
}
