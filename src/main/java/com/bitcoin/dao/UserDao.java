package com.bitcoin.dao;

import org.springframework.stereotype.Repository;

import com.bitcoin.common.dao.BaseDao;
import com.bitcoin.model.User;

@Repository
public class UserDao extends BaseDao<User, String> {
	
}
