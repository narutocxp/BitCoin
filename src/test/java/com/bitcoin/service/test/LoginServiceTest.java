package com.bitcoin.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bitcoin.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class LoginServiceTest {
	
	@Autowired
	private LoginService loginService;

	@Test
	public void testIsLoginSuccess() { 
		 
	   boolean result=loginService.isLoginSuccess("840129008@qq.com", "69a96463081e8c1cee0f2b89f2d4b9fb");
	   
	   System.out.println(result);
	   
	   boolean result2 = loginService.isLoginSuccess("1302665507@qq.com", "69a96463081e8c1cee0f2b89f2d4b9fb");
	   System.out.println(result2);
	    
	}
	
	@Test
	public void testGetVcodeByEmail(){
		
		String result = loginService.getVcodeByEmail("840129008@qq.com");
		
		System.out.println(result);
		
		String result2 = loginService.getVcodeByEmail("0129008@qq.com");
		
		System.out.println(result2);
	}
	
	@Test
	public void testIsCorrectVcoe(){
		System.out.println(loginService.isCorrectVcoe("840129008@qq.com", "KI5L4O", "林"));
		
		System.out.println(loginService.isCorrectVcoe("840108", "KI5L4O", "林"));
	}
	
	@Test
	public void testIsFirstTimeActivate(){
		
		System.out.println(loginService.isFirstTimeActivate("840129008@qq.com"));
		System.out.println(loginService.isFirstTimeActivate("1302665507@qq.com"));
		System.out.println(loginService.isFirstTimeActivate("15507@qq.com"));
	}

}
