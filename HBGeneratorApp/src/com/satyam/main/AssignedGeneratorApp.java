package com.satyam.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.satyam.Model.Employee;
import com.satyam.util.HibernateUtil;

public class AssignedGeneratorApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Employee emp = null;
		boolean flag = false;
		try {
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				emp = new Employee();
//				emp.setEmpId(id);
				emp.setEmpName("virat");
				emp.setEmpSal(99.99);
				session.save(emp);
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object saved to database");
			} else {
				transaction.rollback();
				System.out.println("failed to save to database");
			}
			HibernateUtil.closeSession(session);
		}
	}

}
