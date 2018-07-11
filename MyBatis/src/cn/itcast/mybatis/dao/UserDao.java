package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.po.User;

/**
 * dao接口，用户管理
 * 
 * @author zyloveyy
 *
 */
public interface UserDao {
	
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;
	
	//添加用户信息
	public void insertUser(User user) throws Exception;
	
	//删除用户信息
	public void deletUser(int id) throws Exception;
}
