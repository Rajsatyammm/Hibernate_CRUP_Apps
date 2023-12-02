package com.satyam.main;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.satyam.Model.ProgrammerProjectInfo;
import com.satyam.Model.ProjectInfo;
import com.satyam.util.HibernateUtil;

public class CompositeKeyApp implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		ProjectInfo info = null;
		boolean flag = false;
		try {
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				info = new ProjectInfo(101, "java");
				ProgrammerProjectInfo prjInfo = new ProgrammerProjectInfo(info, "raj", 901, "hibernate");
				session.save(prjInfo);
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
				System.out.println("failed to save to database");
			}
			HibernateUtil.closeSession(session);
		}
	}

}
