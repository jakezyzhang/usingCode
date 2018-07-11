package com.zzy.register.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.zzy.register.dao.BaseDao;
import com.zzy.register.dao.NewsDao;
import com.zzy.register.dao.RSProcessor;
import com.zzy.register.dao.util.Page;
import com.zzy.register.entity.News;

public class NewsDaoImpl extends BaseDao implements NewsDao {
	
	public List<News> getAllNews() {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		//获取所有新闻
		String sql = "select news.id as id, tilte, content, user.display_name as author, date from news, user where news.author_id = user.id order by news.id";
		
		RSProcessor newsProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				List<News> listNews = new ArrayList<News>();
				
				while(rs != null && rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String content = rs.getString("content");
					String author = rs.getString("author");
					Date date = rs.getDate("date");
					String strDate = sdf.format(date);
					
					News news = new News(id, title, content, author, strDate);
					listNews.add(news);
				}
				return listNews;
			}
			
		};
		
		Object result = executeQuery(newsProcessor, sql, null);
		
		return (List<News>)result;
	}

	public List<News> getAllNewsOnlyTitle() {
		String sql = "select id, title from news order by id";
		
		RSProcessor newsProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				List<News> listNews = new ArrayList<News>();
				while(rs != null && rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					
					News news = new News(id, title);
					listNews.add(news);
				}
				return listNews;
			}
			
		};
		
		Object result = executeQuery(newsProcessor, sql, null);
		
		return (List<News>)result;
	}
	
	public List<News> getAllNewsWithTitleAndDate() {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		String sql = "select id, title, date from news order by id";
		
		RSProcessor newsProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				List<News> listNews = new ArrayList<News>();
				while(rs != null && rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					Date date = rs.getDate("date");
					String strDate = sdf.format(date);
					
					News news = new News(id, title, strDate);
					listNews.add(news);
				}
				return listNews;
			}
			
		};
		
		Object result = executeQuery(newsProcessor, sql, null);
		
		return (List<News>)result;
	}

	public News getNewsById(int id) {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		System.out.println("**********************id="+id);
		//获取所有新闻
		String sql = "select news.id as id, title, content, user.display_name as author, date from news, user where news.author_id = user.id and news.id = ?";
		Object[] params = {id};
		
		RSProcessor newsProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				News news = null;
				if(rs != null && rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String content = rs.getString("content");
					String author = rs.getString("author");
					Date date = rs.getDate("date");
					String strDate = sdf.format(date);
					
					news = new News(id, title, content, author, strDate);
				}
				else {
					System.err.println("rs == null || !rs.next()");
				}
				return news;
			}
			
		};
		
		Object result = executeQuery(newsProcessor, sql, params);
		News news = (News)result;
		if(result == null) {
			System.out.println("result is null");
		}
		//System.out.println(news.getAuthor());
		return (News)result;
	}

	public int addNews(News news, int userId) {
		String sql = "insert into news (title, content, date, author_id) values(?, ?, now(), ?)";
		Object[] params = {news.getTitle(), news.getContent(), userId};
		
		return this.executeUpdate(sql, params);
	}
	
	public List<News> getPageNewsList(int pageNo, int pageSize){
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		String sql="select id, title, date from news limit ?,?";
		Object[] params = {(pageNo - 1) * pageSize, pageSize};
		
		RSProcessor newsProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				
				List<News> listNews = new ArrayList<News>();
				
				while(rs != null && rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					Date date = rs.getDate("date");
					String strDate = sdf.format(date);
					
					News news = new News(id, title, strDate);
					listNews.add(news);
				}
				
				return listNews;
			}
		};
		
		Object result = executeQuery(newsProcessor, sql, params);
		
		return (List<News>)result;
	}

	public int getTotalCount() {
		
		String sql="select count(1) as r_count from news";
		
		RSProcessor newsProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				int count = 0;
				if(rs.next()) {
					count = rs.getInt("r_count");
				}
				return count;
			}
		};
		
		Object result = executeQuery(newsProcessor, sql, null);
		
		return (Integer)result;
	}
	
}
