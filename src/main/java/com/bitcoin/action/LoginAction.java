package com.bitcoin.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bitcoin.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;


@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace(value="/*")
public class LoginAction  extends ActionSupport {
	
	private String userMail;
	private String userPassword;

	@Autowired
	private LoginService loginService;

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	@Action(value="login",results={@Result(name="success",location="/page/loginSuccess.jsp"),@Result(name="error",location="/page/loginFail.jsp")})
	public String login() throws Exception{
		
		 if(loginService.isLoginSuccess(userMail,userPassword))
			 return SUCCESS;
		 
		 return ERROR;
		
		
	}
	
	
}
