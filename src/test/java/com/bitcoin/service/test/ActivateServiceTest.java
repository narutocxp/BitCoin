package com.bitcoin.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bitcoin.service.ActivateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ActivateServiceTest {

	@Autowired
	private ActivateService activateService;
	
	@Test
	public void testIsFirstTimeLogin() {
		System.out.println(activateService.isFirstTimeLogin("840129008@qq.com"));
	}
	
	@Test
	public void testIsWithinTime(){
		System.out.println(activateService.isWithinTime("1302665507@qq.com"));
		System.out.println(activateService.isWithinTime("840129008@qq.com"));
	}

}
