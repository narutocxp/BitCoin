package com.bitcoin.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_transaction_recorded")
public class TransactionRecord {

	private String id;
	private String walletRemit;
	private String walletImport;
	private double recordedAmount;
	private String recordedTime;
	private int recorded_is_finish;
	private int recorded_is_success;
	private Wallet wallet;
	
	@ManyToOne
	@JoinColumn(name="wallet_address")
	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	@Id 
	@GeneratedValue(generator = "paymentableGenerator")    
	@GenericGenerator(name = "paymentableGenerator", strategy = "guid")   
	@Column(name="id",length=32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="wallet_remit",length=16,nullable=false) 
	public String getWalletRemit() {
		return walletRemit;
	}

	public void setWalletRemit(String walletRemit) {
		this.walletRemit = walletRemit;
	}
   
	@Column(name="wallet_import",length=16,nullable=false)
	public String getWalletImport() {
		return walletImport;
	}

	public void setWalletImport(String walletImport) {
		this.walletImport = walletImport;
	}

	@Column(name="recorded_amount",precision=9,scale=1,nullable=false)
	public double getRecordedAmount() {
		return recordedAmount;
	}

	public void setRecordedAmount(double recordedAmount) {
		this.recordedAmount = recordedAmount;
	}

	@Column(name="recorded_time",nullable=false)
	public String getRecordedTime() {
		return recordedTime;
	}

	public void setRecordedTime(String recordedTime) {
		this.recordedTime = recordedTime;
	}

	@Column(name="recorded_is_finish",length=1,nullable=false)
	public int getRecorded_is_finish() {
		return recorded_is_finish;
	}

	public void setRecorded_is_finish(int recorded_is_finish) {
		this.recorded_is_finish = recorded_is_finish;
	}

	@Column(name="recorded_is_success",length=1,nullable=false)
	public int getRecorded_is_success() {
		return recorded_is_success;
	}

	public void setRecorded_is_success(int recorded_is_success) {
		this.recorded_is_success = recorded_is_success;
	}

	 
}
