package com.satyam.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class BankAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountNo;

	@Column(length = 20)
	private String holderName;

	@Column(length = 20)
	private String accName;

	private Double balance;

	@CreationTimestamp
	private LocalDateTime openingDate;

	@UpdateTimestamp
	private LocalDateTime lastModified;

	@Version
	private Integer versionCount;

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public LocalDateTime getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDateTime openingDate) {
		this.openingDate = openingDate;
	}

	public LocalDateTime getLastModified() {
		return lastModified;
	}

	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}

	public Integer getVersionCount() {
		return versionCount;
	}

	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", holderName=" + holderName + ", accName=" + accName
				+ ", balance=" + balance + ", openingDate=" + openingDate + ", lastModified=" + lastModified + "]";
	}
}
