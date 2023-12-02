package com.satyam.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.satyam.Model.PersonInfo;
import com.satyam.util.HibernateUtil;

public class SaveOperationApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		boolean flag = false;
		try {
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				LocalDate date = LocalDate.of(2020, 10, 28);
				LocalTime time = LocalTime.of(10, 45);
				PersonInfo person = new PersonInfo();
				person.setpName("rajKumarRao");
				person.setpAddress("MI");
				person.setDoj(time);
				person.setDob(date);
				person.setDom(LocalDateTime.of(date, time));
				session.persist(person);
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
				System.out.println("Failed to save Object to database");
			}
			HibernateUtil.closeSession(session);
		}

	}

}
