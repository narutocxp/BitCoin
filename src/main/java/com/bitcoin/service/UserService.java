package com.bitcoin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcoin.dao.UserDao;
import com.bitcoin.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User  get(String id){
		return userDao.get(id);  
		
	}
	
}
