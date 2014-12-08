package com.bitcoin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcoin.dao.UserDao;
import com.bitcoin.model.User;
import com.bitcoin.utils.MailUtils;

@Service
public class ResetPasswordService {
	
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * 发送重置密码链接到邮箱
	 * @param email
	 * @return
	 */
	public boolean sendEmail(String email){
		String hql = "from User where userMail = ?";
		List<User> users = userDao.find(hql, email);
		if(0 != users.size()){
			//发送邮件到注册邮箱
			MailUtils utils = new MailUtils();
			utils.setUsername("1302665507@qq.com");
			utils.setPassword("dulimima1");
			utils.setSmtpHost("smtp.qq.com");
			
			String mailSubject = "云币账户找回密码";
			String toMail = email;
			String address = "   http://127.0.0.1:8080/team-bitcoin/gotoResetPassword?mail="+email;
			StringBuffer mailContent = new StringBuffer();
			mailContent.append("请点击以下链接进行密码重置").append(address);
			
			if(utils.sendMailUtis(toMail, mailSubject, mailContent.toString())){
				return true;
			}
		}
		
		return false;
		
	}
	
	
	/**
	 * 重置密码
	 * @param email
	 * @param newPassword
	 */
	public void resetPassword(String email, String newPassword){
		String hql = "from User where userMail = ?";
		List<User> users = userDao.find(hql, email);
		
		User u = users.get(0);
		u.setUserPassword(newPassword);
		userDao.update(u);
	}
	

}
