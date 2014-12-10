package com.bitcoin.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.bitcoin.dao.UserDao;
import com.bitcoin.model.User;

@Service
public class CheckTimeService {
	private Logger logger = Logger.getLogger(CheckTimeService.class);

	@Autowired
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 每分钟查看是否有超时未激活的账号。账号的有效激活时间为5分钟
	 */
	@Scheduled(fixedDelay=1000*60)
	public void checkIswithinTime(){
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowStr = sdf.format(now);
		Date nowTime =null;
		try {
			nowTime = sdf.parse(nowStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		List<User> users = userDao.loadAll();
		
		for(User u:users){
			String registerTimeStr = u.getUserRegisterTime();
			Date registerTime = null;
			
			try {
				registerTime = sdf.parse(registerTimeStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(nowTime.getTime()-registerTime.getTime()>1000*60*5 && (null == u.getUserName())){//设置有效激活时间为2分钟
				userDao.delete(u);
			}
		}
		 logger.info("查看是否有超时未激活的用户");
	}
}
