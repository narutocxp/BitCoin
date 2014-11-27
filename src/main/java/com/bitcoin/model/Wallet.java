package com.bitcoin.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="t_wallet")
public class Wallet {

	private String walletAddress;
	private double walletAmount;
	private int walletLocked;
	private String userMail;
	private User user;
	private Set<TransactionRecord> transactionRecord; 

	@Column(name="user_mail",insertable=false,updatable=false,length=20,nullable=false)
	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	@Id
	@Column(name = "wallet_address",length=16)
	public String getWalletAddress() {
		return walletAddress;
	}

	public void setWalletAddress(String walletAddress) {
		this.walletAddress = walletAddress;
	}
    @Column(name="walletAmount",nullable=false,precision=9,scale=1)
	public double getWalletAmount() {
		return walletAmount;
	}

	public void setWalletAmount(double walletAmount) {
		this.walletAmount = walletAmount;
	}

	@Column(name = "wallet_locked",length=1,nullable=false)
	public int getWalletLocked() {
		return walletLocked;
	}

	public void setWalletLocked(int walletLocked) {
		this.walletLocked = walletLocked;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_mail")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany
	public Set<TransactionRecord> getTransactionRecord() {
		return transactionRecord;
	}

	public void setTransactionRecord(Set<TransactionRecord> transactionRecord) {
		this.transactionRecord = transactionRecord;
	}
   
 

}
