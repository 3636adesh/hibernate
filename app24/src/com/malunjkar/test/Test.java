package com.malunjkar.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.malunjkar.entity.Course;
import com.malunjkar.entity.Student;

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

			Set<Course> courses = new HashSet<Course>();
			Course course1 = new Course();
		    course1.setCid("111");
		    course1.setCname("C++");
		    Course course2 = new Course();
		    course2.setCid("222");
		    course2.setCname("Java");
		    courses.add(course2);
		    courses.add(course1);
		    
		    Student  student1 = new Student();
		    Student  student2 = new Student();
		    Student  student3 = new Student();
		    student1.setCourses(courses);
		    student1.setStAdd("pune");
		    student1.setStId(11);
		    student1.setStdName("AAA");
		    
		    student2.setCourses(courses);
		    student2.setStAdd("mum");
		    student2.setStId(12);
		    student2.setStdName("BBB");
		    
		    student3.setCourses(courses);
		    student3.setStAdd("jaipur");
		    student3.setStId(13);
		    student3.setStdName("CCC");
		    
		    session.save(student1);
		    session.save(student2);
		    session.save(student3);
		    
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
