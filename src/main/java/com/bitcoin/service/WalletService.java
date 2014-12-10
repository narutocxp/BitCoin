package com.bitcoin.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcoin.dao.UserDao;
import com.bitcoin.dao.WalletDao;
import com.bitcoin.model.User;
import com.bitcoin.model.Wallet;
import com.bitcoin.utils.IDGenerator;

@Service
public class WalletService {

	@Autowired
	private WalletDao walletDao;
	@Autowired
	private UserDao userDao;

	public List<Wallet> loadAll() {
		return walletDao.loadAll();

	}

	public void add(String userMail) {
		String address = IDGenerator.generatorIdHex();

		User user = userDao.load(userMail);
		Wallet wallet = new Wallet();
		wallet.setUser(user);
		wallet.setWalletAmount(0.0);
		wallet.setWalletAddress(address);
		walletDao.save(wallet);

	}

	public void delete(Wallet wallet) {
		walletDao.delete(wallet);

	}

	public void update(Wallet wallet) {
		walletDao.update(wallet);

	}

	public Wallet load(String walletAddress) {
		return walletDao.get(walletAddress);
	}

	@SuppressWarnings("rawtypes")
	public List<Wallet> getWalletListByLimit(String sql,int from,int amount){
	    List<Map<String,Object>> maps=walletDao.getTListWithLimit(sql, from, amount);
	    List<Wallet> wallets=new ArrayList<Wallet>();
		     
	    Map map=null;
	    Wallet wallet=null;
		     
		Iterator itr=maps.iterator();
	    while(itr.hasNext()){
					
			 map=(Map)itr.next();
			 wallet=new Wallet();
			 wallet.setWalletAddress((String)map.get("wallet_address"));
			 wallet.setWalletAmount(Double.valueOf((map.get("wallet_amount")).toString()));
			 wallet.setWalletLocked(Integer.valueOf(map.get("wallet_locked").toString()));
					 
			 wallets.add(wallet);
		 }
		 return  wallets;
		   
	   }   
	
	public int getCount(String sql){
		return walletDao.getTCount(sql);
		
	}

	public boolean isExistWalletAddress(String walletAddress){
        if(walletDao.get(walletAddress)!=null)
		   return true;
        
	    return  false;
		
	}	
	
}
