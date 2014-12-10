package com.bitcoin.service.test;


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
	public void testCanLogin() {
		String mail = "840129008@qq.com";
		
		System.out.println(registerService.canRegister(mail));
		
	}
	
	@Test
	public void testSave(){
		User u = new User();
		u.setUserMail("1302665507@qq.com");
		u.setUserName("lin");
		u.setUserPassword("a353523534532342sdfgd");
		u.setUserRegisterTime("2014-12-06 13:00:04");
		u.setUserVerificationCode("ABCDEF");
		
		registerService.saveUser(u);
	}
	
	@Test
	public void testIsRegisterSuccess(){
		User u = new User();
		u.setUserMail("1302665507@qq.com");
		u.setUserName("lin");
		u.setUserPassword("a353523534532342sdfgd");
		u.setUserRegisterTime("2014-12-06 13:00:04");
		u.setUserVerificationCode("ABCDEF");
		
		System.out.println(registerService.isRegisterSuccess(u));
		
		User u1 = new User();
		u1.setUserMail("55@qq.com");    //不存在的邮箱
		u1.setUserName("lin");
		u1.setUserPassword("a353523534532342sdfgd");
		u1.setUserRegisterTime("2014-12-06 13:00:04");
		u1.setUserVerificationCode("ABCDEF");
		System.out.println(registerService.isRegisterSuccess(u1));
		
		User u3 = new User();
		u3.setUserMail("840129008@qq.com");
		u3.setUserName("lin");
		u3.setUserPassword("a353523534532342sdfgd");
		u3.setUserRegisterTime("2014-12-06 13:00:04");
		u3.setUserVerificationCode("ABCDEF");
		
		System.out.println(registerService.isRegisterSuccess(u3));
		
	}

}
