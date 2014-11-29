package com.bitcoin.model;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="t_user")
public class User {

	private String userMail;
	private String userPassword;
	private String userName;
	private String userRegisterTime;
	private String userVerificationCode;
	private Set<Wallet> wallets;

	@Id
	@Column(name="user_mail",length=20,nullable=false)
	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	@Column(name="user_password",length=32,nullable=false)
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name="user_name",length=20)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	@OneToMany(mappedBy="user")
	public Set<Wallet> getWallets() {
		return wallets;
	}

	public void setWallets(Set<Wallet> wallets) {
		this.wallets = wallets;
	}
    @Column(name="register_time",length=20)
	public String getUserRegisterTime() {
		return userRegisterTime;
	}

	public void setUserRegisterTime(String userRegisterTime) {
		this.userRegisterTime = userRegisterTime;
	}

	@Column(name="verification_code",length=14)
	public String getUserVerificationCode() {
		return userVerificationCode;
	}

	public void setUserVerificationCode(String userVerificationCode) {
		this.userVerificationCode = userVerificationCode;
	}

	 
	

}
