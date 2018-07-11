package com.rainsia.news.dao;

import java.util.List;

import com.rainsia.news.entity.News;

public interface NewsDao{
	//获取所有新闻
	public List<News> getAllNews();	
	
	public List<News> getAllNewsOnlyTitle();
	
	public List<News> getAllNewsWithTitleAndDate();
	
	public News getNewsById(int id);
	
	public int addNews(News news, int userId);
	
	public List<News> getPageNewsList(int pageNo, int pageSize);
	
	public int getTotalCount();
}