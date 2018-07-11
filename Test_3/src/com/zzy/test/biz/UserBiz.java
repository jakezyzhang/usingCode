package com.zzy.test.biz;

import java.util.List;

import com.zzy.test.entity.User;

public interface UserBiz {
	List<User> getAllUser();
	User getUserById(int Id);
}
