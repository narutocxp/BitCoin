package com.bitcoin.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

 

@Entity
@Table(name="t_message")
public class Message {

	private String id;
	private String messageContent;
	private String walletAddress;
	private Wallet wallet;
	private TransactionRecord transactionRecord;

	@Id 
	@GeneratedValue(generator = "paymentableGenerator")    
	@GenericGenerator(name = "paymentableGenerator", strategy = "guid")   
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
   
	@Column(name="message_content")
	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
    
	@Column(name="wallet_address",insertable=false,updatable=false)
	public String getWalletAddress() {
		return walletAddress;
	}
    
	public void setWalletAddress(String walletAddress) {
		this.walletAddress = walletAddress;
	}
   
	@OneToOne
    @PrimaryKeyJoinColumn(name="id")
	public TransactionRecord getTransactionRecord() {
		return transactionRecord;
	}

	public void setTransactionRecord(TransactionRecord transactionRecord) {
		this.transactionRecord = transactionRecord;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="wallet_address")
	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

}