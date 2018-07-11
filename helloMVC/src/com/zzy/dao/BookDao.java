package com.zzy.dao;

import java.util.*;
import java.sql.*;


import com.zzy.entity.Book;
import com.zzy.util.BaseDao;

public class BookDao extends BaseDao{
	public List<Book> getAll(){
		List<Book> list = new ArrayList<Book>();
		String sql = "select * from book";
		try {
			ResultSet rs = this.executeQuery(sql);
			while(rs.next()){
				list.add(new Book(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4)));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return list;
	}
	public Book getById(int id){
		
		String sql = "select * from book where id=?";
		try {
			ResultSet rs = this.executeQuery(sql,id);
			while(rs.next()){
				return new Book(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));
				
				
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
		String sql = "insert into book(name,price,author) values(?,?,?)";
		return this.exceuteUpdate(sql, b.getName(),b.getPrice(),b.getAuthor());
	}
	//修改书籍
	
	public int update(Book b){
		String sql = "update book set name=?,price=?,author=? where id=?";
		return this.exceuteUpdate(sql, b.getName(),b.getPrice(),b.getAuthor(),b.getId());
		 
	}
	//删除
	public int delete(int id){
		String sql = "delete from book where id=?";
		return this.exceuteUpdate(sql, id);
	}
}
