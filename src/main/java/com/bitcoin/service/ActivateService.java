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
	
	
	public boolean isFirstTimeLogin(String userEmail){
		String hql = "from User where userMail=?";
		List<User> users = userDao.find(hql,userEmail);
		if(null == users.get(0).getUserName())
			return true;
		return false;
	}
}
