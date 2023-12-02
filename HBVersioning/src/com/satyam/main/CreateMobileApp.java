package com.satyam.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.satyam.Model.Mobile;
import com.satyam.util.HibernateUtil;

public class CreateMobileApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		boolean flag = false;
		Mobile mobile = null;
		try {
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				mobile = new Mobile();
				mobile.setmName("Nokia");
				mobile.setmTone("hand shake");
				session.save(mobile);
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object saved to DB...");
			} else {
				transaction.rollback();
				System.out.println("Failed to save the object to DB...");
			}
		}

	}

}
