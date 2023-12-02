package com.satyam.main;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.satyam.Model.Employee;
import com.satyam.util.HibernateUtil;

public class DBRowToEntityApp {

	public static void main(String[] args) throws IOException {

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
				System.out.println("Before Modification in the table:: " + emp);
				System.in.read();
				
//				session.refresh(emp);
				System.out.println("After Modifiaction in the table :: " + emp);
			} else
				System.out.println("Record not available");
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
