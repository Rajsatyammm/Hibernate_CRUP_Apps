package com.satyam.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.satyam.Model.Employee;
import com.satyam.util.HibernateUtil;

public class DeleteApp {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Employee emp = null;
		try {
			if(session != null) {
				emp = new Employee();
				emp.setEmpId(1);
				session.delete(args);
			}
			transaction.commit();
			
		} catch(HibernateException e) {
			e.printStackTrace();
		}
		
		

	}

}
