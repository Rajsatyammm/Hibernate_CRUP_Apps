package com.satyam.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.satyam.Model.Employee;
import com.satyam.util.HibernateUtil;

public class DeleteApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Employee employee = null;
		boolean flag = false;
		try {
			if (session != null)
				transaction = session.beginTransaction();
			if (transaction != null)
				employee = session.get(Employee.class, 2);

			if (employee != null) {
				session.delete(employee);
				flag = true;
			}
			else {
				System.out.println("cant able to find Object...");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object deleted successfully...");
			} else {
				transaction.rollback();
				System.out.println("Failed to delete Object...");
			}
		}

	}
}
