package com.bitcoin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcoin.dao.UserDao;
import com.bitcoin.model.User;

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
		if(canRegister(user.getUserMail())){
			this.saveUser(user);
			return true;
		}
		
		return false;
	}
}
