package com.bitcoin.service.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bitcoin.dao.UserDao;
import com.bitcoin.model.User;
import com.bitcoin.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class LoginServiceTest {
	
	@Autowired
	private LoginService loginService;

	@Test
	public void test() { 
		 
	   boolean result=loginService.isLoginSuccess("343009086@qq.com", "123456");
	   
	   System.out.println(result);
	    
	}
	
	@Test
	public void testIsCorrectVcoe(){
		boolean result = loginService.isCorrectVcoe("840129008@qq.com", "7林I3OU1", "xiao");
		
		System.out.println(result);
	}

}
