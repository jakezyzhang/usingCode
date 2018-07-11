package com.rainsia.news.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.rainsia.news.dao.BaseDao;
import com.rainsia.news.dao.RSProcessor;
import com.rainsia.news.dao.UserDao;
import com.rainsia.news.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	public int insert(User user) {
		String sql = "insert user (username, display_name, password, role_id) values(?,?,?,?)";
		Object[] params = {user.getName(), user.getDisplayName(), user.getPassword(), user.getRole()};
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

		RSProcessor getUserByNameProcessor = new RSProcessor() {

			public Object process(ResultSet rs) throws SQLException {
				User user = null;
				
				if(rs != null) {
					if(rs.next()) {
						int id = rs.getInt("id");
						String username = rs.getString("username");
						String displayName = rs.getString("display_name");
						//String email = rs.getString("email");
						String password = rs.getString("password");
						int role = rs.getInt("role_id");
						
						user = new User(id, username, displayName, password, role);
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
					String username = rs.getString("username");
					String displayName = rs.getString("display_name");
					//String email = rs.getString("email");
					String password = rs.getString("password");
					int role = rs.getInt("role_id");
					
					User user = new User(id, username, displayName, password, role);
					users.add(user);
				}
				
				return users;
				
			}

		};
		
		return (Vector<User>)this.executeQuery(getUsersByNameProcessor, sql, params);
	}
}
