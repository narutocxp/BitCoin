package com.bitcoin.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;


@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace(value = "/*")
public class GotoResetPassword extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String mail;
	
	
	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}



	@Action(value="gotoResetPassword",results={@Result(name="success",location="/WEB-INF/setPassword.jsp")})
	public String gotoResetPassword (){
		return SUCCESS;
		
	}

}
