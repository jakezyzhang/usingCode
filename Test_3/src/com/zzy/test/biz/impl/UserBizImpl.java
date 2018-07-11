package com.zzy.test.biz.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.zzy.test.biz.util.BizUtil;

import com.zzy.test.biz.UserBiz;
import com.zzy.test.dao.UserDao;
import com.zzy.test.entity.User;

public class UserBizImpl implements UserBiz{

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		UserDao userDao = null;
		try {
			userDao = (UserDao) BizUtil.getDialectedDao(UserDao.class);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(userDao != null) {
			List<User> alluserBrief = userDao.getAllUserBrief();
			return alluserBrief;
		}
		return null;
	}

	@Override
	public User getUserById(int Id) {
		// TODO Auto-generated method stub
		UserDao userDao = null;
		try {
			userDao = (UserDao) BizUtil.getDialectedDao(UserDao.class);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
