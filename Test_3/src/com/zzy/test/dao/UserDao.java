package com.zzy.test.dao;

import java.util.List;
import java.util.Vector;



import com.zzy.test.entity.*;

public interface UserDao {
	List<User> getAllUserBrief();
	User getUserNameById(int id);
	List<User> getUserNameByName(String username);
	//查找用户
	public int countUserByName(String name);
	public User findUserByName(String name);
	public Vector<User> findUsersByName(String name);
	//添加用户
	public int insert(User user);
	
}
