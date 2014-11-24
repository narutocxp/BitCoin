package com.bitcoin.dao;

import org.springframework.stereotype.Repository;

import com.bitcoin.common.dao.BaseDao;
import com.bitcoin.model.TransactionRecord;

@Repository
public class TransactionRecordDao extends BaseDao<TransactionRecord, String> {

}
