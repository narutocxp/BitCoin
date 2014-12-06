package com.bitcoin.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcoin.dao.TransactionRecordDao;
import com.bitcoin.dao.WalletDao;
import com.bitcoin.model.TransactionRecord;
import com.bitcoin.model.Wallet;
import com.bitcoin.page.PageModel;
import com.bitcoin.page.PageResult;


@Service
public class RecordService {

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
	 * 根据信息生成一条交易记录并写入数据库
	 * @param formAddress
	 * @param toAddress
	 * @param amount
	 */

	public void createRecord(String formAddress, String toAddress, double amount){
		TransactionRecord record = new TransactionRecord();
		record.setRecorded_is_finish(0);
		record.setRecorded_is_success(0);
		record.setRecordedAmount(amount);
		record.setWalletImport(toAddress);
		record.setWalletRemit(formAddress);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		record.setRecordedTime(sdf.format(new Date()));
		
		String hql = "from Wallet where walletAddress=?";
		Wallet w = walletDao.find(hql, formAddress).get(0);
		record.setWallet(w);
		transactionRecordDao.save(record);
	}
	
	/**
	 * 根据查询条件返回查询结果的第一页
	 * @param queryKey
	 * @return
	 */
	public PageModel getFirstPage(int queryKey1, int queryKey2){
		PageModel pageModel = new PageModel();
		List<PageResult> pageResults = getTransaction(queryKey1, queryKey2);
		pageModel.setCurrentPage(1);
		pageModel.setQueryKey1(queryKey1);
		pageModel.setQueryKey2(queryKey2);
		pageModel.setTotalPage(getTotalPage(pageResults.size()));
		
		if(0 == pageResults.size()){
			pageModel.setTotalPage(1);
			pageModel.setContent(pageResults);
			return pageModel;
		}
		
		List<PageResult> content = new ArrayList<PageResult>();
		
		if(pageResults.size() > PageModel.PER_PAGE_COUNT){
			for(int i=0; i<PageModel.PER_PAGE_COUNT; i++){
				content.add(pageResults.get(i));
			}
			
		}else{
			for(int i=0; i<pageResults.size(); i++){
				content.add(pageResults.get(i));
			}
		}
		
		pageModel.setContent(content);
		return pageModel;
	}
	
	/**
	 * 获取前一页
	 * @param currentPage
	 * @param queryKey
	 * @return
	 */
	public PageModel getBeforePage(int currentPage, int queryKey1, int queryKey2){
		PageModel pageModel = new PageModel();
		List<PageResult> pageResults = getTransaction(queryKey1, queryKey2);
		pageModel.setQueryKey1(queryKey1);
		pageModel.setQueryKey2(queryKey2);
		pageModel.setTotalPage(getTotalPage(pageResults.size()));
		
		if(0 == pageResults.size()){
			pageModel.setTotalPage(1);
			pageModel.setContent(pageResults);
			pageModel.setCurrentPage(1);
			return pageModel;
		}
		
		List<PageResult> content = new ArrayList<PageResult>();
		
		if(1 == currentPage){  //第一页
			pageModel.setCurrentPage(1);
			
			if(pageResults.size() > PageModel.PER_PAGE_COUNT){
				for(int i=0; i<PageModel.PER_PAGE_COUNT; i++){
					content.add(pageResults.get(i));
				}
			}else{
				for(int i=0; i<pageResults.size(); i++){
					content.add(pageResults.get(i));
				}
			}
			
			pageModel.setContent(content);
			return pageModel;
		}
		
		pageModel.setCurrentPage(currentPage - 1);
		
		if(pageResults.size() > PageModel.PER_PAGE_COUNT*(currentPage-1)-1){
			for(int i = PageModel.PER_PAGE_COUNT*(currentPage-2); i<=PageModel.PER_PAGE_COUNT*(currentPage-1)-1; i++){
				content.add(pageResults.get(i));
				
			}
		}else{
			for(int i = PageModel.PER_PAGE_COUNT*(currentPage-2); i<pageResults.size(); i++){
				content.add(pageResults.get(i));
				
			}
		}
		
		pageModel.setContent(content);
		
		return pageModel;
	}
	
	
	/**
	 * 获取下一页
	 * @param currentPage
	 * @param queryKey
	 * @return
	 */
	public PageModel getAfterPage(int currentPage,int queryKey1, int queryKey2){
		PageModel pageModel = new PageModel();
		List<PageResult> pageResults = getTransaction(queryKey1, queryKey2);
		pageModel.setQueryKey1(queryKey1);
		pageModel.setQueryKey2(queryKey2);
		pageModel.setTotalPage(getTotalPage(pageResults.size()));
		
		if(0 == pageResults.size()){
			pageModel.setTotalPage(1);
			pageModel.setContent(pageResults);
			pageModel.setCurrentPage(1);
			return pageModel;
		}
		
		List<PageResult> content = new ArrayList<PageResult>();
		
		if(pageModel.getTotalPage() == currentPage){  //最后一页
			pageModel.setCurrentPage(currentPage);
			
			if(pageResults.size() > PageModel.PER_PAGE_COUNT*currentPage-1){
				for(int i=PageModel.PER_PAGE_COUNT*(currentPage-1); i<=PageModel.PER_PAGE_COUNT*currentPage-1; i++){
					content.add(pageResults.get(i));
				}
			}else{
				for(int i=PageModel.PER_PAGE_COUNT*(currentPage-1); i<pageResults.size(); i++){
					content.add(pageResults.get(i));
				}
			}
			
			pageModel.setContent(content);
			return pageModel;
		}
		
		pageModel.setCurrentPage(currentPage + 1);
		
		if(pageResults.size() > PageModel.PER_PAGE_COUNT*(currentPage+1)-1){
			for(int i = PageModel.PER_PAGE_COUNT*currentPage; i<=PageModel.PER_PAGE_COUNT*(currentPage+1)-1; i++){
				content.add(pageResults.get(i));
				
			}
		}else{
			for(int i = PageModel.PER_PAGE_COUNT*currentPage; i<pageResults.size(); i++){
				content.add(pageResults.get(i));
				
			}
		}
		
		pageModel.setContent(content);
		return pageModel;
	}
	
	
	/**
	 * 根据查询的条件获取查询结果集
	 * @param queryKey
	 * @return
	 */
	public List<PageResult> getTransaction(int key1, int key2){
		List<TransactionRecord> records = transactionRecordDao.loadAll();
		List<PageResult> result = new ArrayList<PageResult>();
		
		if(1 == key1 && 1 == key2){
			for(TransactionRecord t: records){
				
				PageResult p = new PageResult();
				p.setAddress(t.getWalletRemit());
				p.setType("汇出");
				p.setAmount(t.getRecordedAmount());
				p.setTime(t.getRecordedTime());
				p.setState(getState(t));
				result.add(p);
				
				PageResult p2 = new PageResult();
				p2.setAddress(t.getWalletImport());
				p2.setType("汇入");
				p2.setAmount(t.getRecordedAmount());
				p2.setTime(t.getRecordedTime());
				p2.setState(getState(t));
				result.add(p2);
			}
			
			return result;
		}
		
		if(1 == key1 && 2 == key2){
			for(TransactionRecord t: records){
				if(0 == t.getRecorded_is_finish()){
					
					PageResult p = new PageResult();
					p.setAddress(t.getWalletRemit());
					p.setType("汇出");
					p.setAmount(t.getRecordedAmount());
					p.setTime(t.getRecordedTime());
					p.setState(getState(t));
					result.add(p);
					
					PageResult p2 = new PageResult();
					p2.setAddress(t.getWalletImport());
					p2.setType("汇入");
					p2.setAmount(t.getRecordedAmount());
					p2.setTime(t.getRecordedTime());
					p2.setState(getState(t));
					result.add(p2);
					
				}
			}
			
			return result;
		}
		
		
		if(1 == key1 && 3 == key2){
			for(TransactionRecord t: records){
				if(1 == t.getRecorded_is_success()){
					
					PageResult p = new PageResult();
					p.setAddress(t.getWalletRemit());
					p.setType("汇出");
					p.setAmount(t.getRecordedAmount());
					p.setTime(t.getRecordedTime());
					p.setState(getState(t));
					result.add(p);
					
					PageResult p2 = new PageResult();
					p2.setAddress(t.getWalletImport());
					p2.setType("汇入");
					p2.setAmount(t.getRecordedAmount());
					p2.setTime(t.getRecordedTime());
					p2.setState(getState(t));
					result.add(p2);
					
				}
			}
			return result;
		}
		
		if(1 == key1 && 4 == key2){
			for(TransactionRecord t: records){
				if(0 == t.getRecorded_is_success()){
					
					PageResult p = new PageResult();
					p.setAddress(t.getWalletRemit());
					p.setType("汇出");
					p.setAmount(t.getRecordedAmount());
					p.setTime(t.getRecordedTime());
					p.setState(getState(t));
					result.add(p);
					
					PageResult p2 = new PageResult();
					p2.setAddress(t.getWalletImport());
					p2.setType("汇入");
					p2.setAmount(t.getRecordedAmount());
					p2.setTime(t.getRecordedTime());
					p2.setState(getState(t));
					result.add(p2);
					
				}
			}
			return result;
		}
		
		
		if(2 == key1 && 1 == key2){
			for(TransactionRecord t: records){
				
				PageResult p2 = new PageResult();
				p2.setAddress(t.getWalletImport());
				p2.setType("汇入");
				p2.setAmount(t.getRecordedAmount());
				p2.setTime(t.getRecordedTime());
				p2.setState(getState(t));
				result.add(p2);
			}
			return result;
		}
			
		if(2 == key1 && 2 == key2){
			for(TransactionRecord t: records){
				if(0 == t.getRecorded_is_finish()){
					
					PageResult p2 = new PageResult();
					p2.setAddress(t.getWalletImport());
					p2.setType("汇入");
					p2.setAmount(t.getRecordedAmount());
					p2.setTime(t.getRecordedTime());
					p2.setState(getState(t));
					result.add(p2);
				}
			}
			return result;
		}
		
		if(2 == key1 && 3 == key2){
			for(TransactionRecord t: records){
				if(1 == t.getRecorded_is_success()){
					
					PageResult p2 = new PageResult();
					p2.setAddress(t.getWalletImport());
					p2.setType("汇入");
					p2.setAmount(t.getRecordedAmount());
					p2.setTime(t.getRecordedTime());
					p2.setState(getState(t));
					result.add(p2);
				}
			}
			return result;
		}
		
		if(2 == key1 && 4 == key2){
			for(TransactionRecord t: records){
				if(0 == t.getRecorded_is_success()){
					
					PageResult p2 = new PageResult();
					p2.setAddress(t.getWalletImport());
					p2.setType("汇入");
					p2.setAmount(t.getRecordedAmount());
					p2.setTime(t.getRecordedTime());
					p2.setState(getState(t));
					result.add(p2);
				}
			}
			return result;
		}
		
		if(3 == key1 && 1 == key2){
			for(TransactionRecord t: records){
				
				PageResult p = new PageResult();
				p.setAddress(t.getWalletRemit());
				p.setType("汇出");
				p.setAmount(t.getRecordedAmount());
				p.setTime(t.getRecordedTime());
				p.setState(getState(t));
				result.add(p);
			}
			return result;
		}
		
		if(3 == key1 && 2 == key2){
			for(TransactionRecord t: records){
				if(0 == t.getRecorded_is_finish()){
					
					PageResult p = new PageResult();
					p.setAddress(t.getWalletRemit());
					p.setType("汇出");
					p.setAmount(t.getRecordedAmount());
					p.setTime(t.getRecordedTime());
					p.setState(getState(t));
					result.add(p);
				}
			}
			return result;
		}
		
		if(3 == key1 && 3 == key2){
			for(TransactionRecord t: records){
				if(1 == t.getRecorded_is_success()){
					
					PageResult p = new PageResult();
					p.setAddress(t.getWalletRemit());
					p.setType("汇出");
					p.setAmount(t.getRecordedAmount());
					p.setTime(t.getRecordedTime());
					p.setState(getState(t));
					result.add(p);
				}
			}
			return result;
		}
		
		if(3 == key1 && 4 == key2){
			for(TransactionRecord t: records){
				if(0 == t.getRecorded_is_success()){
					
					PageResult p = new PageResult();
					p.setAddress(t.getWalletRemit());
					p.setType("汇出");
					p.setAmount(t.getRecordedAmount());
					p.setTime(t.getRecordedTime());
					p.setState(getState(t));
					result.add(p);
				}
			}
			return result;
		}
		
		return result;
	}
	
	public int getTotalPage(int totalCount){
		if(0 == totalCount%PageModel.PER_PAGE_COUNT){
			return totalCount / PageModel.PER_PAGE_COUNT;
		}
		return totalCount / PageModel.PER_PAGE_COUNT + 1;
	}
	
	public String getState(TransactionRecord record){
		if(0 == record.getRecorded_is_finish())
			return "等待";
		if(0 == record.getRecorded_is_success())
			return "失败";
		return "完成";
	}
}
