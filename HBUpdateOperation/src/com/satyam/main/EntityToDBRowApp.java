package com.satyam.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.satyam.Model.Employee;
import com.satyam.util.HibernateUtil;

public class EntityToDBRowApp {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Employee emp = null;
		boolean flag = false;
		Integer id = 5;
		try {
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null)
				emp = session.get(Employee.class, id);

			if (emp != null) {
				System.out.println(emp);
				emp.setEmpSal(20000.0);
			} else {
				System.out.println("record not available...");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object updated...");
			} else {
				transaction.rollback();
				System.out.println("Object failed to update... ");
			}
			HibernateUtil.closeSession(session);
		}

	}

}
