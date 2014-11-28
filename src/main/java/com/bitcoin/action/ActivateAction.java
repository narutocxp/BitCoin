package com.bitcoin.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bitcoin.model.User;
import com.bitcoin.service.ActivateService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace(value="/*")
public class ActivateAction extends ActionSupport implements ModelDriven<User>{

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	@Autowired
	private ActivateService activateService;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ActivateService getActivateService() {
		return activateService;
	}

	public void setActivateService(ActivateService activateService) {
		this.activateService = activateService;
	}


	@Override
	@Action(value="activate",results={@Result(name="success",location="/WEB-INF/firstlogin.jsp"),@Result(name="error",location="/login.jsp"),@Result(name="input",location="/register.jsp")})
	public String execute() throws Exception {
		if(!activateService.isWithinTime(user.getUserMail()))
			return INPUT;
		
		if(activateService.isFirstTimeLogin(user.getUserMail()))
			return SUCCESS;
		return ERROR;
	}

	public User getModel() {
		return this.user;
	}
	
}
