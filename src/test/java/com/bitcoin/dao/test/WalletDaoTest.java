package com.bitcoin.dao.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



import com.bitcoin.dao.UserDao;
import com.bitcoin.dao.WalletDao;
import com.bitcoin.model.User;
import com.bitcoin.model.Wallet;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class WalletDaoTest {

	@Autowired
	private UserDao userDao;
	@Autowired
	private WalletDao walletDao;
	
	@Test
	public void test() {
		
	   int currentCount=walletDao.getCount("from Wallet");
	  
	   User user=new User();
	   user.setUserMail("169608181011");
	   user.setUserPassword("4094098409");
	   userDao.save(user);
	   Wallet wallet=new Wallet();
	   wallet.setUser(user);
	   wallet.setWalletAddress("123456789");
	   wallet.setWalletLocked(0);
	   wallet.setWalletAmount(10.9);
	   walletDao.save(wallet);
	   
	   int nowCount=walletDao.getCount("from Wallet");
	   Assert.assertTrue(currentCount+1==nowCount);
	   
	}

}
