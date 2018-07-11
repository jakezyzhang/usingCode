package com.zzy.dao;

import java.util.*;
import java.sql.*;


import com.zzy.entity.Book;
import com.zzy.util.BaseDao;
import com.zzy.util.PageUtil;

public class BookDao extends BaseDao{
	public List<Book> getAll(PageUtil pu){
		List<Book> list = new ArrayList<Book>();
		String sql = "select * from book limit ?,?";
		try {
			ResultSet rs = this.executeQuery(sql,(pu.getCurrentPage()-1)*pu.getPageSize(),pu.getPageSize());
			while(rs.next()){
				list.add(new Book(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getInt(5)));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return list;
	}
	//获取总共记录数
	public int count(){
		String sql="select count(1) from book";
		try{
			ResultSet rs = this.executeQuery(sql);
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			this.closeAll();
		}
		return 0;
	}
	public Book getById(int id){
		
		String sql = "select * from book where id=?";
		try {
			ResultSet rs = this.executeQuery(sql,id);
			while(rs.next()){
				return new Book(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getInt(5));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return null;
	}
	
	public int add(Book b){
		String sql = "insert into book(name,price,author,categoryId) values(?,?,?,?)";
		return this.exceuteUpdate(sql, b.getName(),b.getPrice(),b.getAuthor(),b.getCategoryId());
	}
	//修改书籍
	
	public int update(Book b){
		String sql = "update book set name=?,price=?,author=?,categoryId=? where id=?";
		return this.exceuteUpdate(sql, b.getName(),b.getPrice(),b.getAuthor(),b.getCategoryId(),b.getId());
		 
	}
	//删除
	public int delete(int id){
		String sql = "delete from book where id=?";
		return this.exceuteUpdate(sql, id);
	}
}
