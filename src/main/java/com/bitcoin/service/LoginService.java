package com.bitcoin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcoin.dao.UserDao;
import com.bitcoin.model.User;

@Service
public class LoginService {

	@Autowired
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
    /**
     * 登录判断
     * @param userMail  登录邮箱
     * @param userPassword  登录密码
     * @return
     */
	public boolean isLoginSuccess(String userMail,String userPassword){
		
		List<User> users = (List<User>)userDao.loadAll();
		if(0 == users.size())
			return false;
		
		for(User u:users){
			if(userMail.trim().equals(u.getUserMail())&&userPassword.trim().equals(u.getUserPassword())&&(null != u.getUserName())){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 根据Email获取对应用户的激活码
	 * @param email
	 * @return
	 */
	public String getVcodeByEmail(String email){
		
		List<User> users = userDao.loadAll();
		
		for(User u: users){
			if(email.equals(u.getUserMail()))
				return u.getUserVerificationCode();
		}
		
		return null;
	}
	
	
	/**
	 * 判断给定邮箱的激活码是否正确
	 * @param email
	 * @param vCode
	 * @param userName
	 * @return
	 */
	public boolean isCorrectVcoe(String email, String vCode,String userName){
		if(vCode.equals(getVcodeByEmail(email))){   //激活码正确
			//设置用户名
			String hql = "from User where userMail = ?";
			List<User> users = userDao.find(hql, email);
			
			users.get(0).setUserName(userName);
			userDao.update(users.get(0));
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * 是否是首次激活
	 * @param email
	 * @return
	 */
	public boolean isFirstTimeActivate(String email){
		String hql = "from User where userMail = ?";
		List<User> users = userDao.find(hql, email);
		
		if(0 == users.size())
			return false;
		
		if(null == users.get(0).getUserName())
			return true;
		
		return false;
	}
}
