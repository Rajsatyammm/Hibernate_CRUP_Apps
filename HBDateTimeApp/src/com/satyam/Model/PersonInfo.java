package com.satyam.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
@Table(name = "person")
public class PersonInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pId;

	@Column(length = 20)
	private String pName;

	@Column(length = 20)
	private String pAddress;

//	@Temporal(TemporalType.DATE)
	private LocalDate dob;

//	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dom;

//	@Temporal(TemporalType.TIME)
	private LocalTime doj;

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpAddress() {
		return pAddress;
	}

	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDateTime getDom() {
		return dom;
	}

	public void setDom(LocalDateTime dom) {
		this.dom = dom;
	}

	public LocalTime getDoj() {
		return doj;
	}

	public void setDoj(LocalTime doj) {
		this.doj = doj;
	}

}
