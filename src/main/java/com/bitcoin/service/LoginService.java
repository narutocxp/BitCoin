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
			if(userMail.trim().equals(u.getUserMail())&&userPassword.trim().equals(u.getUserPassword())){
				return true;
			}
		}
		
		return false;
	}
}
