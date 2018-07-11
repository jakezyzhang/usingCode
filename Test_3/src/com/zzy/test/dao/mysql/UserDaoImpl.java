package com.zzy.test.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


import com.zzy.dao.base.BaseDao;
import com.zzy.dao.base.RSProcessor;
import com.zzy.test.dao.UserDao;
import com.zzy.test.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {
	@SuppressWarnings("unchecked")
	
	public List<User> getAllUserBrief() {
		// TODO Auto-generated method stub
		String sql = "select id,username,password,displayname from user";
		
		RSProcessor userRS = new RSProcessor() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				List<User> userList = new ArrayList<User>();
				while(rs.next()){
					int id = rs.getInt("id");
					String username = rs.getString("username");
					String password = rs.getString("password");
					String displayname = rs.getString("displayname");
					
					User user = new User(id, username, password, displayname);
					userList.add(user);
				}
				return userList;
			}
		};
		
		return (List<User>) executeQuery(userRS, sql);
	}
	
	public User getUserNameById(int Id) {
		// TODO Auto-generated method stub
		String sql="select * from user where id = ?";
		
		RSProcessor userRS = new RSProcessor() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				User user = null;
				if(rs.next()){
					int Id= rs.getInt("id");
					String username = rs.getString("username");
					String password = rs.getString("password");
					String displayname = rs.getString("displayname");
					 user = new User(Id, username,password,displayname);
				}
				return user;
			}
		};
		
		return (User)executeQuery(userRS, sql, Id);
	}
	
	public int insert(User user) {
		String sql = "insert user (username, password,displayname) values(?,?,?)";
		Object[] params = {user.getUsername(), user.getPassword(), user.getDisplayname()};
		return this.executeUpdate(sql, params);
	}

	public int countUserByName(String name) {
		String sql = "select count(*) as user_count from user where username=?";
		Object[] params = {name};
		
		RSProcessor countUserByNameProcessor = new RSProcessor(){

			public Object process(ResultSet rs) throws SQLException {
				int count = 0;
				if(rs != null) {
					if(rs.next()) {
						count = rs.getInt("user_count");
					}
				}
				
				return new Integer(count);
			}

		};
		
		return (Integer)this.executeQuery(countUserByNameProcessor, sql, params);
	}
	
	public User findUserByName(String name) {
		String sql = "select * from user where username = ?";
		Object[] params = {name};

		RSProcessor getUserByNameProcessor = new RSProcessor(){

			public Object process(ResultSet rs) throws SQLException {
				User user = null;
				
				if(rs != null) {
					if(rs.next()) {
						int id = rs.getInt("id");
						String username = rs.getString("username");
						String password = rs.getString("password");
						String displayname = rs.getString("displayname");
						user = new User(id, username, password, displayname);
					}
				}
				
				return user;
				
			}

		};
		
		return (User)this.executeQuery(getUserByNameProcessor, sql, params);
	}

	public Vector<User> findUsersByName(String name) {
		String sql = "select * from user where username = ?";
		Object[] params = {name};

		RSProcessor getUsersByNameProcessor = new RSProcessor(){

			public Object process(ResultSet rs) throws SQLException {
				Vector<User> users = new Vector<User>();
				
				while(rs.next()) {
					int id = rs.getInt("id");
					String username = rs.getString("password");
					String password = rs.getString("username");
					String displayname = rs.getString("displayname");
					
					User user = new User(id, username, password, displayname);
					users.add(user);
				}
				
				return users;
				
			}

		};
		
		return (Vector<User>)this.executeQuery(getUsersByNameProcessor, sql, params);
	}
	
	public List<User> getUserNameByName(String username){
		String sql = "select * from user where username = ?";
		Object[] params = {username};
		
		RSProcessor getAllUsername = new RSProcessor() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				List<User> userList = new ArrayList<User>();
				
				while(rs.next()){
					int id = rs.getInt("id");
					String username = rs.getString("username");
					String password = rs.getString("password");
					String displayname = rs.getString("displayname");
					
					User user = new User(id, username, password, displayname);
					userList.add(user);
				}
				return userList;
			}
		};
		return (List<User>)this.executeQuery(getAllUsername, sql, params);
	}
}
