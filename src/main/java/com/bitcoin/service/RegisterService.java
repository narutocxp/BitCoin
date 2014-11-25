package com.bitcoin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcoin.dao.UserDao;
import com.bitcoin.model.User;
import com.bitcoin.utils.MailUtils;
import com.bitcoin.utils.VCodeUtils;

@Service
public class RegisterService {

	@Autowired
	private UserDao userDao;
	
	
	/**
	 * 判断给定的邮箱是否能够注册
	 * @param mail
	 * @return
	 */
	public boolean canRegister(String mail){
		List<User> users = (List<User>)userDao.loadAll();
		
		if(null == users || 0 == users.size()){
			return true;
		}
		
		for(User u: users){
			if(mail.trim().equals(u.getUserMail()))
				return false;
		}
		
		return true;
	}
	
	/**
	 * 保存用户
	 * @param user
	 */
	public void saveUser(User user){
		userDao.save(user);
	}
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public boolean isRegisterSuccess(User user){
		if(canRegister(user.getUserMail())){  //用户可以正常注册
			this.saveUser(user);    //保存用户信息
			
			//发送邮件到注册邮箱
			MailUtils utils = new MailUtils();
			utils.setUsername("1302665507@qq.com");
			utils.setPassword("dulimima1");
			utils.setSmtpHost("smtp.qq.com");
			
			String vcode = VCodeUtils.Vcode(6);
			String mailSubject = "云币账户激活";
			String toMail = user.getUserMail();
			String address = "  http://127.0.0.1:8080/team-bitcoin/firstlogin/firstlogin.jsp";
			StringBuffer mailContent = new StringBuffer();
			mailContent.append("您的云币账户已准备就绪！请点击以下链接进行激活，并输入验证码：").append(vcode).append(address);
			
			utils.sendMailUtis(toMail, mailSubject, mailContent.toString());
			
			return true;
		}
		
		return false;
	}
}
