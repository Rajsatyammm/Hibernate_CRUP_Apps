package com.satyam.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.satyam.Model.Employee;
import com.satyam.util.HibernateUtil;

public class UpdateAppUsingMerge {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Employee emp1 = null;
		Employee emp2 = null;
		boolean flag = false;
		Integer id = 5;
		try {
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				emp1 = session.get(Employee.class, id);

				if (emp1 != null) {
					emp2 = new Employee();
					emp2.setEmpId(emp1.getEmpId());
					emp2.setEmpName("SEHWAG");
					emp2.setEmpSal(999);

					session.merge(emp2);
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
