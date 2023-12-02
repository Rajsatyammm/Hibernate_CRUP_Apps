package com.satyam.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.satyam.Model.Employee;
import com.satyam.util.HibernateUtil;

public class ReadAppUsingLoad {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Integer id = 4;
		Employee emp = null;
		try {
			if (session != null)
				emp = session.load(Employee.class, id);
				System.out.println("EmpId : emp.getEmpId() :: " + emp.getEmpId());
//			if (emp != null) {
//				System.out.println("Name : emp.getName() :: " + emp.getEmpName());
//				
//			}
		} catch (HibernateException e) {
			System.out.println("No object found by id :: " + id);
		}

	}
}
