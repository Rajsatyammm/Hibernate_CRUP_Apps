package com.satyam.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.satyam.Model.Employee;
import com.satyam.util.HibernateUtil;

public class UpdateAppUsingUpdate {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Employee emp = null;
		boolean flag = false;
		Integer id = 5;
		try {
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				emp = session.get(Employee.class, id);

				if (emp != null) {
					emp.setEmpName("MSD");
					emp.setEmpSal(1000);

					session.update(emp);
					flag = true;
				}
				else {
					System.out.println("Object not found for id :: " + id);
				}
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
