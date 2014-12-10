package com.bitcoin.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bitcoin.model.User;
import com.bitcoin.service.LoginService;
import com.bitcoin.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace(value = "/*")
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String userMail;
	private String userPassword;
	Map<String, Object> m = ServletActionContext.getContext().getSession();
	private HttpServletRequest request = ServletActionContext.getRequest();

	@Autowired
	private LoginService loginService;
	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

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

	@Override
	@Action(value = "login", results = {
			@Result(name = "success", location = "/WEB-INF/loginSuccess.jsp"),
			@Result(name = "error", location = "/WEB-INF/information.jsp") })
	public String execute() throws Exception {

		if (loginService.isLoginSuccess(userMail, userPassword)) {
			User user=userService.get(userMail);
			m.put("user", user);
			return SUCCESS;

		}else{
			Map<String, Object> info = new HashMap<String, Object>();
			info.put("state", "ERROR!");
			info.put("prompt", "warning:登录失败，账号或密码错误！");
			info.put("url", "login.jsp");
			info.put("next", "点击返回");
			info.put("img", "error.jpg");
			request.setAttribute("info", info);

			return ERROR;
		}
	}

}
