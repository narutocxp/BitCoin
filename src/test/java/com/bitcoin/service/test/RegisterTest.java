package com.bitcoin.service.test;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bitcoin.model.User;
import com.bitcoin.service.RegisterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class RegisterTest {

	@Autowired
	private RegisterService registerService;
	
	@Test
	public void test() {
		User user = new User();
		user.setUserMail("1302665507@qq.com");
		user.setUserName("linxiaofei");
		user.setUserPassword("123456");
		boolean isSuccess = registerService.isRegisterSuccess(user);
	
		Assert.assertTrue(isSuccess);
	}

}
