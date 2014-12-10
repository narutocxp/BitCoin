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
import com.bitcoin.service.RegisterService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace(value="/*")
public class RegisterAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	private User user;
	@Autowired
	private RegisterService registerService;
	private HttpServletRequest request=ServletActionContext.getRequest();
	
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getModel() {
		return user;
	}
	
	@Action(value="register",results={@Result(name="success",location="/WEB-INF/information.jsp"),@Result(name="error",location="/WEB-INF/information.jsp")})
	public String register() throws Exception{
		 
		Map<String,Object> info=new HashMap<String,Object>();
	    int state=registerService.isRegisterSuccess(user);
		if(state==1){
		     info.put("state", "SUCCESS!");
			 info.put("prompt", "注册成功，您必须在5分钟内到你的邮箱验证，否则帐号将失效!");
			 info.put("url", "registerlogin");
			 info.put("next", "立即登录");
			 info.put("img", "success.jpg");
			 request.setAttribute("info", info);
			 return SUCCESS;
		 
		}else if(state==0){
			 info.put("state", "ERROR!");
			 info.put("prompt", "warning:注册失败，你输入的行已被占用！");
			 info.put("url", "register.jsp");
			 info.put("next", "点击返回");
			 info.put("img", "error.jpg");
			 request.setAttribute("info", info);
			 
			 return ERROR;
			 
		}else{
			 
			 info.put("state", "ERROR!");
			 info.put("prompt", "warning:注册失败，你输入的邮箱不存在");
			 info.put("url", "register.jsp");
			 info.put("next", "点击返回");
			 info.put("img", "error.jpg");
			 request.setAttribute("info", info);
			 
			 return ERROR;
		 }
	}

}
