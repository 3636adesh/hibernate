package com.malunjkar.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.malunjkar.entity.CardPayment;
import com.malunjkar.entity.ChequePayment;


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
			CardPayment cardPayment= new CardPayment();
			cardPayment.setCardNo("111");
			cardPayment.setExpDate("1-1-2022");
			
			cardPayment.setPayAmt("50000");
			cardPayment.setPayDate("2-2-2023");
			cardPayment.setTxId("123");
			
			ChequePayment chequePayment= new ChequePayment();
			chequePayment.setAccNo("676");
			chequePayment.setChequeNo("342");
			
			chequePayment.setPayAmt("400");
			chequePayment.setPayDate("21-1-2026");
			chequePayment.setTxId("125");
			
			String cheP=(String)session.save(chequePayment);
			String cardP=(String)session.save(cardPayment);
			System.out.println(cheP+"chequePayment save");
			System.out.println(cardP+"cardPayment save");
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
