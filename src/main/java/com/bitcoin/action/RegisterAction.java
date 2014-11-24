package com.bitcoin.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bitcoin.model.User;
import com.bitcoin.service.RegisterService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace(value="/example")
public class RegisterAction extends ActionSupport implements ModelDriven<User> {

	private User user;
	@Autowired
	private RegisterService registerService;
	
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getModel() {
		return user;
	}
	@Action(value="register",results={@Result(name="success",location="/success.jsp")})
	public String register() throws Exception{
		
		 if(registerService.isRegisterSuccess(user))
			 return SUCCESS;
		 
		 return ERROR;
		
		
	}

}
