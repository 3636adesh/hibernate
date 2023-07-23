package com.malunjkar.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.malunjkar.enitity.Employee;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory =null;
		Session session = null;
		Transaction tx = null;
		try {
			Configuration cfg = new Configuration();
			cfg.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
			cfg.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
			cfg.setProperty("hibernate.connection.username", "postgres");
			cfg.setProperty("hibernate.connection.password", "3636@Adesh");
			cfg.setProperty("hibernate.show_sql", "true");
			cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		//	cfg.addResource("com/malunjkar/resources/Employee.hbm.xml"); 
			cfg.addAnnotatedClass(Employee.class);
			 sessionFactory = cfg.buildSessionFactory();
			 session=sessionFactory.openSession();
			 tx = session.beginTransaction();
				Employee employee = new Employee();
				employee.setEno(111);
				employee.setEname("Yash");
				employee.setEsal(2000);
				employee.setEadd("Pune");
				int eno = (int) session.save(employee);
				if (eno == 111)
					System.out.println("Employee saved");
				else
					System.out.println("Employee not save");
				tx.commit();
		} catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			if(session !=null)
				session.close();
			if(sessionFactory !=null)
				sessionFactory.close();
			e.printStackTrace();
		}
	}
}
