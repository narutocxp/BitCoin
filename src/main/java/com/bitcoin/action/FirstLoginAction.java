package com.bitcoin.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bitcoin.model.User;
import com.bitcoin.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace(value="/*")
public class FirstLoginAction extends ActionSupport implements ModelDriven<User>{

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	@Autowired
	private LoginService loginService;
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	@Action(value="firstLogin",results={@Result(name="success",location="/page/loginSuccess.jsp"),@Result(name="error",location="/firstlogin/firstlogin.jsp")})
	public String execute() throws Exception {
		if(loginService.isCorrectVcoe(user.getUserMail(), user.getUserVerificationCode(),user.getUserName()))
			return SUCCESS;
		
		return ERROR;
	}


	public User getModel() {
		return this.user;
	}
	
	

}
