package com.bitcoin.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bitcoin.service.ResetPasswordService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace(value = "/*")
public class ResetPasswordAction extends ActionSupport implements RequestAware{
	
	private static final long serialVersionUID = 1L;
	
	private String mail;
	private String newPassword;
	private Map<String , Object> request;
	
	@Autowired
	private ResetPasswordService resetPasswordService;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public ResetPasswordService getResetPasswordService() {
		return resetPasswordService;
	}

	public void setResetPasswordService(ResetPasswordService resetPasswordService) {
		this.resetPasswordService = resetPasswordService;
	}
	
	@Action(value="resetPassword",results={@Result(name="success",location="/login.jsp")})
	public String resetPassword(){
		resetPasswordService.resetPassword(mail, newPassword);
		return SUCCESS;
	}
	
	@Action(value="sendEmail",results={@Result(name="success",location="/login.jsp"),@Result(name="error",location="/resetpassword.jsp")})
	public String sendEmail(){
		if(resetPasswordService.sendEmail(mail)){
			request.put("hist", "邮件发送成功，请及时登录邮箱进行密码重置");
			return SUCCESS;
		}
		request.put("hist", "邮件发送失败，请检查邮箱是否正确");
		return ERROR;
		
	}

	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

}
