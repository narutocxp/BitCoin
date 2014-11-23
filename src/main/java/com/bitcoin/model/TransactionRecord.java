package com.bitcoin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="t_transaction_recorded")
public class TransactionRecord {

	private String id;
	private int recordedType;
	private double recordedAmount;
	private Date recordedTime;
	private int recorded_is_finish;
	private int recorded_is_success;
	private Message message;


	@Id 
	@GeneratedValue(generator = "idGenerator")  
	@GenericGenerator(name = "idGenerator", strategy = "foreign",   
	         parameters = { @Parameter(name = "property", value = "message") }) 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="recorded_type")
	public int getRecordedType() {
		return recordedType;
	}

	public void setRecordedType(int recordedType) {
		this.recordedType = recordedType;
	}
   
	@Column(name="recorded_amount")
	public double getRecordedAmount() {
		return recordedAmount;
	}

	public void setRecordedAmount(double recordedAmount) {
		this.recordedAmount = recordedAmount;
	}

	@Column(name="recorded_time")
	public Date getRecordedTime() {
		return recordedTime;
	}

	public void setRecordedTime(Date recordedTime) {
		this.recordedTime = recordedTime;
	}

	@Column(name="recorded_is_finish")
	public int getRecorded_is_finish() {
		return recorded_is_finish;
	}

	public void setRecorded_is_finish(int recorded_is_finish) {
		this.recorded_is_finish = recorded_is_finish;
	}

	@Column(name="recorded_is_success")
	public int getRecorded_is_success() {
		return recorded_is_success;
	}

	public void setRecorded_is_success(int recorded_is_success) {
		this.recorded_is_success = recorded_is_success;
	}

	@OneToOne
    @PrimaryKeyJoinColumn(name="id")
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
