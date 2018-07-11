package tanyamei.biz.impl;

import tanyamei.biz.LoginBiz;
import tanyamei.dao.UserDao;
import tanyamei.dao.impl.UserDaoImpl;
import tanyamei.entity.User;

public class LoginBizImpl implements LoginBiz{
	private UserDao userDao = new UserDaoImpl();
	public User login(String username, String password) {
		User user = userDao.findUserByUsername(username);
		if(user != null && user.getPassword().equals(password)){
			return user;
		}
		return null;
	}

}
