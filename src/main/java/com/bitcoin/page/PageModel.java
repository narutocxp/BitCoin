package com.bitcoin.page;

import java.util.List;


public class PageModel {
	private int queryKey1;
	private int queryKey2;
	private List<PageResult> content;
	private int currentPage;
	private int totalPage;
	public static final int PER_PAGE_COUNT = 4;
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<PageResult> getContent() {
		return content;
	}
	public void setContent(List<PageResult> content) {
		this.content = content;
	}
	public int getQueryKey1() {
		return queryKey1;
	}
	public void setQueryKey1(int queryKey1) {
		this.queryKey1 = queryKey1;
	}
	public int getQueryKey2() {
		return queryKey2;
	}
	public void setQueryKey2(int queryKey2) {
		this.queryKey2 = queryKey2;
	}
	
}
