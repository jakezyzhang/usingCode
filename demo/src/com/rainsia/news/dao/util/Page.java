package com.rainsia.news.dao.util;

import java.util.List;

import com.rainsia.news.entity.News;

public class Page {
	//总页数
	private int totalPageCount=1;
	//页面大小，即每页显示记录数
	private int pageSize=0;
	//记录总数
	private int totalCount=0;
	//当前页号
	private int currPageNo=1;
	//每页新闻集合
	List<News> newsList; 
	
	public List<News> getListNews() {
		return newsList;
	}
	public void setListNews(List<News> listNews) {
		this.newsList = listNews;
	}
	public int getCurrPageNo() {
		if(totalPageCount==0)
			return 0;
		return currPageNo;
	}
	public void setCurrPageNo(int currPageNo) {
		if(this.currPageNo>0)
			this.currPageNo = currPageNo;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
			this.totalPageCount = totalPageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(pageSize>0)
			this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		if(totalCount>0){
			this.totalCount = totalCount;
			//计算总页数
			totalPageCount=this.totalCount%pageSize==0?(this.totalCount/pageSize):
				this.totalCount/pageSize+1;
		}
	}
}
