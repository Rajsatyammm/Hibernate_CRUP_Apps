package com.satyam.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="Employee")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Employee {
	@Id
	@Column(name="eid")
	private int empId;
	
	@Column(name="ename")
	private String empName;
	
	@Column(name="esal")
	private double empSal;
	
	static {
		System.out.println("static block of Employee...");
	}
	
	public Employee() {
		System.out.println("No argument constructor (Employee) is called...");
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
	}
}
