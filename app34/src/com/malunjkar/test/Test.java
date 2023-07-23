package com.malunjkar.test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.malunjkar.entity.Employee;

public class Test {

	public static void main(String[] args) throws Exception {
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		StandardServiceRegistry serviceRegistry = null;
		try {
			configuration = new Configuration();
			configuration.configure("/com/malunjkar/resources/hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(configuration.getProperties());
			serviceRegistry = builder.build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			session = sessionFactory.openSession();
			Query query = session.createQuery("from Employee");
			Filter filter = session.enableFilter("emp_filter");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Employee type:-");
			System.out.println("1 Permant");
			System.out.println("2 Temporary");
			int i = scanner.nextInt();
			if (1 == i)
				filter.setParameter("type", "param");
			if (2 == i)
				filter.setParameter("type", "temp");
			List<Employee> emps = query.list();
			emps.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
			if (serviceRegistry != null)
				StandardServiceRegistryBuilder.destroy(serviceRegistry);
		}

	}
}
