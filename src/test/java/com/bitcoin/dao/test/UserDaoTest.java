package com.bitcoin.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bitcoin.dao.UserDao;
import com.bitcoin.model.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UserDaoTest {

	@Autowired
	 private UserDao userDao;  
	
	@Test
	public void test() {
		 
		User  user=new User();
		user.setUserMail("65196085");
		user.setUserName("narutocxp");
		user.setUserPassword("616409");
		userDao.save(user);
		
	}

}
