package com.bitcoin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
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
@Namespace(value="/*")
public class LogoutAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request=ServletActionContext.getRequest();
	
    @Action(value="logout",results={@Result(name="success",location="/login.jsp")})
	public String logout() throws Exception{
    	
    	  HttpSession session=request.getSession();
    	  session.invalidate();
    	  return SUCCESS;
    	
    }
	
}
