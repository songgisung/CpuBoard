package com.board.myapp.vo;

public class BoardPage {
	private int currentPage;
	private int pageSize;
	private int totalCount;
	private int totalPage;
	private int startPage;
	private int endPage;
	private int start;
	


	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	//totalPage,startpage,endpage 
	public BoardPage(int currentPage,int pageSize, int totalcount) {
		this.currentPage = currentPage;
		this.pageSize =  pageSize;
		this.totalCount = totalcount;
		
		totalPage = (this.totalCount - 1) / pageSize;
		//currentPage totalPage 
		this.currentPage = currentPage > totalPage ? totalPage:currentPage;
		this.currentPage = currentPage < 1 ? 1:currentPage;
		
		startPage =  (this.currentPage -1)/10*pageSize+1;
	
		start = (currentPage - 1)*10;
		endPage =  startPage + 9;
	
		endPage = endPage > totalPage ? totalPage : endPage;
		
	}
//	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize =  pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount =  totalCount;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage =  totalPage;
	}
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
}
