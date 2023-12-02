package com.satyam.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.satyam.Model.Employee;
import com.satyam.util.HibernateUtil;

public class CreateAppUsingPersist {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Employee emp = null;
		boolean flag = false;
		Integer id = 5;
		String name = "rajkumar";
		Double sal = 1.5;
		try {
			if(session != null) 
				transaction = session.beginTransaction();
			
			if(transaction != null) {
				emp = new Employee();
				emp.setEmpName(name);
				emp.setEmpId(id);
				emp.setEmpSal(sal);
				session.persist(emp);
				flag = true;
			}
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object saved to database");
			}
			else {
				transaction.rollback();
				System.out.println("Failed to save Object to database");
			}
			HibernateUtil.closeSession(session);
		}

	}
}
