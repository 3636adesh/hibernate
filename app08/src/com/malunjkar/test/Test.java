package com.malunjkar.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.malunjkar.enitity.Employee;

public class Test {

	public static void main(String[] args) throws IOException {
		SessionFactory sessionFactory = null;
		Session session = null;
		FileInputStream fis =null;
		try {
			Configuration cfg = new Configuration();
			// cfg.addResource("Employee.hbm.xml");
			cfg.addAnnotatedClass(Employee.class);
			fis = new FileInputStream("D:\\hibernate\\app08\\src\\abc.properties");
			Properties properties = new Properties();
			properties.load(fis);
			cfg.setProperties(properties);
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			Employee employee = (Employee) session.get(Employee.class, 111);
			System.out.println(employee);
		} catch (Exception e) {
			if(fis!=null)
				fis.close();
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
			e.printStackTrace();
		}
	}
}
