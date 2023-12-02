package com.satyam.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.satyam.Model.BankAccount;
import com.satyam.util.HibernateUtil;

public class UpdateAccountApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		boolean flag = false;
		BankAccount account = null;
		try {
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				account = session.get(BankAccount.class, 10);
			}
			if (account != null) {
				account.setAccName("current");
				account.setBalance(500.0);
				account.setHolderName("kumar");

				session.save(account);
				flag = true;
			} else
				System.out.println("Object not found to be modified...");

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
