package com.malunjkar.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.procedure.ProcedureCall;

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
			/*
			 * SQLQuery sqlQuery =
			 * session.createSQLQuery("select * from emp1 where e_no = ?");
			 * sqlQuery.setInteger(0, 1); sqlQuery.addEntity(Employee.class); List<Employee>
			 * emps=sqlQuery.list();
			 */
			Query query = session.getNamedQuery("sql_query");
			query.setInteger(0, 1);
			List<Employee> emps = query.list();
			emps.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
			StandardServiceRegistryBuilder.destroy(serviceRegistry);
		}

	}
}
