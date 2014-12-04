package com.bitcoin.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.bitcoin.dao.TransactionRecordDao;
import com.bitcoin.dao.WalletDao;
import com.bitcoin.model.TransactionRecord;
import com.bitcoin.model.Wallet;

@Service
public class TransferAccountService {
	
	Logger logger = Logger.getLogger(TransferAccountService.class);
	
	@Autowired
	private TransactionRecordDao transactionRecordDao;
	@Autowired
	private WalletDao walletDao;
	
	public TransactionRecordDao getTransactionRecordDao() {
		return transactionRecordDao;
	}

	public void setTransactionRecordDao(TransactionRecordDao transactionRecordDao) {
		this.transactionRecordDao = transactionRecordDao;
	}


	public WalletDao getWalletDao() {
		return walletDao;
	}

	public void setWalletDao(WalletDao walletDao) {
		this.walletDao = walletDao;
	}

	/**
	 * 每两分钟进行一次转账
	 */
	@Scheduled(fixedDelay=1000*60*2)
	public void TransferAccount(){
		//获取所有还未进行过转账的记录
		String hql = "from TransactionRecord where recorded_is_finish = ?";
		List<TransactionRecord> recoreds = transactionRecordDao.find(hql, 0);
		if(0 == recoreds.size())
			return;
	
		for(TransactionRecord recored : recoreds){
			//获取汇出的账户
			String address = recored.getWalletRemit();
			String hql2 = "from Wallet where walletAddress = ?";
			List<Wallet> wallets = walletDao.find(hql2, address);
			Wallet wallet = wallets.get(0);
			
			//汇款失败
			if(0.0 > wallet.getWalletAmount()){
				logger.info(recored.getWalletRemit()+"向"+recored.getWalletImport()+"转账失败");
				//将钱退还汇出账户
				wallet.setWalletAmount(wallet.getWalletAmount()+recored.getRecordedAmount());
				walletDao.update(wallet);
				//将该条汇款记录的结果设置为失败及设置为已经调度过
				recored.setRecorded_is_finish(1);
				recored.setRecorded_is_success(0);
				transactionRecordDao.update(recored);
			}else{   //汇款成功
				logger.info(recored.getWalletRemit()+"向"+recored.getWalletImport()+"转账成功");
				//向汇入账户增加金额
				String address2 = recored.getWalletImport();
				String hql3 = "from Wallet where walletAddress = ?";
				List<Wallet> wallets2 = walletDao.find(hql3, address2);
				Wallet wallet2 = wallets2.get(0);
				wallet2.setWalletAmount(wallet2.getWalletAmount()+recored.getRecordedAmount());
				walletDao.update(wallet2);
				//将该条汇款记录的结果设置为成功及设置为已经调度过
				recored.setRecorded_is_finish(1);
				recored.setRecorded_is_success(1);
				transactionRecordDao.update(recored);
			}
		}
	
	}

}
