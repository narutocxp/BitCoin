package com.bitcoin.dao;

import org.springframework.stereotype.Repository;

import com.bitcoin.common.dao.BaseDao;
import com.bitcoin.model.Message;

@Repository
public class MessageDao extends BaseDao<Message, String> {

}
