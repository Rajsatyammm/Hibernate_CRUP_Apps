package com.satyam.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.satyam.Model.Mobile;
import com.satyam.util.HibernateUtil;

public class UpdateMobileApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		boolean flag = false;
		Mobile mobile = null;
		try {
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				mobile = session.get(Mobile.class, 2);
				mobile.setmName("Nokiaa Lumia");
//				mobile.setmTone("lumia");
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object updated to DB...");
			} else {
				transaction.rollback();
				System.out.println("Failed to update the object to DB...");
			}
		}

	}

}
