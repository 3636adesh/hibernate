package com.malunjkar.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		try {
			configuration = new Configuration();
			configuration.configure("/com/malunjkar/resources/hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(configuration.getProperties());
			StandardServiceRegistry serviceRegistry = builder.build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			Criterion c1 = Restrictions.gt("esal", 100000);
			Criterion c2 = Restrictions.le("esal", 3000);
			criteria.add(c1);
			criteria.add(c2);
			
			Projection p1= Projections.property("eno");
			Projection p2= Projections.property("ename");
			Projection p3= Projections.property("esal");
			Projection p4= Projections.property("eadd");
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(p1);
			projectionList.add(p2);
			projectionList.add(p3);
			projectionList.add(p4);
			criteria.setProjection(projectionList);
			
			Order or = Order.desc("ename");
			criteria.addOrder(or);
			
			List<Object[]> list = criteria.list();
			for (Object[] objs : list) {
				for (Object obj : objs)
					System.out.print(obj+"\t");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
		}

	}
}
