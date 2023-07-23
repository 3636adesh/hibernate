package com.malunjkar.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.malunjkar.entity.Employee;
import com.malunjkar.util.HibernateUtil;

public class EmployeeService {

	Session session = null;
	Query query = null;
	public EmployeeService() {
		
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			query = session.createQuery("from Employee");
			query = query.setMaxResults(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Employee> getEmpList(String label) {
		List<Employee> employees = null;
		try {
			if (label.equals("1")) 
                    query.setFirstResult(0);
			if (label.equals("2")) 
				query.setFirstResult(3);
			if(label.equals("3")) 
				query.setFirstResult(6);
			employees=query.list();
		} catch (Exception e) {
		}
		return employees;
	}
}
