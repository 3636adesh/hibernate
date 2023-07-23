package com.malunjkar.test;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.malunjkar.entity.Employee;

public class Test {

	public static void main(String[] args) throws Exception {
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session openSession = sessionFactory.openSession();
		Transaction transaction = openSession.beginTransaction();
		Employee employee = new Employee();
		employee.setEno(222);
		employee.setEname("AAA");
		employee.setEaddress("Jaipur");
		employee.setEsal(4000d);
//		Serializable serializable = openSession.save(employee);
//		int eno =(int)serializable;
		openSession.persist(employee);
		transaction.commit();
//		if(eno == 111) {
//			System.out.println("Employee inserted successfully.");
//		}else {
//			System.out.println("Employee not inserted.");
//		}
		openSession.close();
		sessionFactory.close();
	}
}
