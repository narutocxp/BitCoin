package com.bitcoin.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bitcoin.service.ActivateService;
import com.opensymphony.xwork2.ActionSupport;


@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace(value="/*")
public class ActivateAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String userEmail;
	
	@Autowired
	private ActivateService activateService;

	public ActivateService getActivateService() {
		return activateService;
	}

	public void setActivateService(ActivateService activateService) {
		this.activateService = activateService;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	@Action(value="activate",results={@Result(name="success",location="/firstlogin/firstlogin.jsp"),@Result(name="error",location="/login.jsp")})
	public String execute() throws Exception {
		if(activateService.isFirstTimeLogin(userEmail))
			return SUCCESS;
		return ERROR;
	}
	
	

}
