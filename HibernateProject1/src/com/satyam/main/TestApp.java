package com.satyam.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.satyam.Model.Employee;

public class TestApp {

	public static void main(String[] args) {
		
		// step 1: creating a configuration object
		Configuration cfg = new Configuration();
		
		// step 2: configure the hibernate.cfg.xml file
		cfg.configure();
		
		// step 3: get a SessionFactory Object
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		// step 4: get session object
		Session session = sessionFactory.openSession();
		
		// step 5: begin the transaction with a session
		Transaction transaction = session.beginTransaction();
		
		Employee emp = new Employee();
		emp.setEmpId(1);
		emp.setEmpName("raj");
		emp.setEmpSal(10);
		
		// step 6: perform operation
		session.save(emp);
		
		// step 7: performing Transaction operation
		transaction.commit();
		
		// step 8: closing the session
		session.close();
		
		
		
		
		
	}

}
