package com.bitcoin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcoin.dao.UserDao;
import com.bitcoin.model.User;


@Service
public class ActivateService {

	@Autowired
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * 判断是否是首次激活
	 * @param userEmail
	 * @return
	 */
	public boolean isFirstTimeLogin(String userEmail){
		String hql = "from User where userMail=?";
		List<User> users = userDao.find(hql,userEmail);
		if(null == users.get(0).getUserName())
			return true;
		return false;
	}
	
	
	
	/**
	 * 判断用户的激活链接是否过期
	 * @param userEmail
	 * @return
	 */
	public boolean isWithinTime(String userEmail){
		String hql = "from User where userMail=?";
		List<User> users = userDao.find(hql,userEmail);
		
		if(0 == users.size())
			return false;
		
		return true;
	}
	
}
