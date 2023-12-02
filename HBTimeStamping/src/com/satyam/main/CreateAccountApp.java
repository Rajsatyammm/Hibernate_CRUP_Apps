package com.satyam.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.satyam.Model.BankAccount;
import com.satyam.util.HibernateUtil;

public class CreateAccountApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		boolean flag = false;
		BankAccount account = null;
		try {
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				account = new BankAccount();
				account.setAccName("saving");
				account.setBalance(50000.0);
				account.setHolderName("raj kumar");
				
				session.save(account);
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
