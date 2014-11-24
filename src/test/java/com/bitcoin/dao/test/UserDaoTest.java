package com.bitcoin.dao.test;

import org.junit.Assert;
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
		 
		int currentCount=userDao.getCount("from User");
		User  user=new User();
		user.setUserMail("651960851");
		user.setUserPassword("616409");
		userDao.save(user);
		int nowCount=userDao.getCount("from User");
		
		Assert.assertTrue(currentCount+1==nowCount);
		
	}

}
