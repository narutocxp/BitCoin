package com.bitcoin.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bitcoin.page.PageModel;
import com.bitcoin.service.RecordService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace(value="/*")
public class RecordAction extends ActionSupport implements ModelDriven<PageModel>, RequestAware{

	private static final long serialVersionUID = 1L;
	
	private String address;
	private String toAddress;
	private double amount;
	
	@Autowired
	private RecordService recordService;
	private PageModel pageModel;
	private Map<String , Object> request;
	
	public Map<String, Object> getRequest() {
		return request;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public RecordService getRecordService() {
		return recordService;
	}
	public void setRecordService(RecordService recordService) {
		this.recordService = recordService;
	}
	public PageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
		
	}
	public PageModel getModel() {
		return this.pageModel;
	}
	
	@Action(value="createRecord",results={@Result(name="success",location="/WEB-INF/loginSuccess.jsp")})
	public String createRecord(){
		recordService.createRecord(address, toAddress, amount);
		request.put("tip", "操作完成，请及时查看交易记录");
		return SUCCESS;
	}
	
	@Action(value="getFirstPage",results={@Result(name="success",location="/WEB-INF/records.jsp")})
	public String getFirstPage(){
		PageModel firstPage = recordService.getFirstPage(pageModel.getQueryKey1(), pageModel.getQueryKey2());
		request.put("page", firstPage);
		request.put("results", firstPage.getContent());
		request.put("queryKey1", firstPage.getQueryKey1());
		request.put("queryKey2", firstPage.getQueryKey2());
		return SUCCESS;
	}
	
	@Action(value="getBeforePage",results={@Result(name="success",location="/WEB-INF/records.jsp")})
	public String getBeforePage(){
		PageModel beforePage = recordService.getBeforePage(pageModel.getCurrentPage(), pageModel.getQueryKey1(), pageModel.getQueryKey2());
		request.put("page", beforePage);
		request.put("results", beforePage.getContent());
		request.put("queryKey1", beforePage.getQueryKey1());
		request.put("queryKey2", beforePage.getQueryKey2());
		return SUCCESS;
	}
	
	@Action(value="getAfterPage",results={@Result(name="success",location="/WEB-INF/records.jsp")})
	public String getAfterPage(){
		PageModel afterPage = recordService.getAfterPage(pageModel.getCurrentPage(), pageModel.getQueryKey1(), pageModel.getQueryKey2());
		request.put("page", afterPage);
		request.put("results", afterPage.getContent());
		request.put("queryKey1", afterPage.getQueryKey1());
		request.put("queryKey2", afterPage.getQueryKey2());
		return SUCCESS;
	}
}
