package com.bitcoin.dao.test;

import java.util.List;

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
	public void testGetCount() {
		 
		int currentCount=userDao.getCount("from User");
		User  user=new User();
		user.setUserMail("651960851");
		user.setUserPassword("616409");
		userDao.save(user);
		int nowCount=userDao.getCount("from User");
		
		Assert.assertTrue(currentCount+1==nowCount);
		
	}
	
	@Test
	public void testFind(){
		
		String hql = "from User where userMail=?";
		List<User> users = userDao.find(hql,"240775261@qq.com");
		if(null == users.get(0).getUserName())
			 Assert.assertTrue(false);
		else
			Assert.assertTrue(true);
	}
	
	@Test
	public void testLoadAll(){
		
		int currentCount=userDao.getCount("from User");
		List<User> users=userDao.loadAll();
		
		Assert.assertTrue(currentCount==users.size());
	}
	
}
