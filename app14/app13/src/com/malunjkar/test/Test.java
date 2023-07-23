package com.malunjkar.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.malunjkar.entity.EmployeeAccount;
import com.malunjkar.entity.StudentAccount;

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
			StudentAccount stdAcc =new StudentAccount();
			stdAcc.setsId(111);
			stdAcc.setSbranch("Mech");
			stdAcc.setSmarks(48);
			
			stdAcc.setAccType("Current");
			stdAcc.setAccName("TP");
			stdAcc.setAccNo("1234556");
			
			EmployeeAccount empAcc = new EmployeeAccount();
			empAcc.setEno(111);
			empAcc.setEadd("Mumbai");
			empAcc.setEname("BBB");
			empAcc.setEsal(5500);
			
			empAcc.setAccName("Saving");
			empAcc.setAccType("SVG");
			empAcc.setAccNo("1234534");
			
			String eno=(String)session.save(empAcc);
			String sid=(String) session.save(stdAcc);
			
			System.out.println(eno+"EMPLOYEE SAVE");
			System.out.println(sid+"STUDENT SAVE");
			
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
