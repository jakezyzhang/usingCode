package tanyamei.dao;

import tanyamei.entity.User;

public interface UserDao {

	public int insert(User user);
	public User findUserByUsername(String name);
}
