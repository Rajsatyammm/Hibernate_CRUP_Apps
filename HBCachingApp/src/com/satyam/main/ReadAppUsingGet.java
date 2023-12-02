package com.satyam.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.satyam.Model.Employee;
import com.satyam.util.HibernateUtil;

public class ReadAppUsingGet {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Integer id = 1;
		Employee emp = null;
		try {
			if (session != null)
				emp = session.get(Employee.class, id);
			if (emp == null) {
				System.out.println("Record not found by id :: " + id);
			} else {
				System.out.println("1 :: "+ emp);
				System.out.println("Record shown successfully :: ");
				System.out.println("2 :: " + emp);
				
				session.evict(emp);
				session.clear();
				
				emp = session.get(Employee.class, id);
				System.out.println("3 :: " + emp);
				
			}
		} catch (HibernateException e) {
			System.out.println("No object found by id :: " + id);
		}

	}
}
