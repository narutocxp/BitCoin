package com.bitcoin.dao;

import org.springframework.stereotype.Repository;

import com.bitcoin.common.dao.BaseDao;
import com.bitcoin.model.Wallet;

@Repository
public class WalletDao extends BaseDao<Wallet, String> {

}
