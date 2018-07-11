package com.zzy.test.dao;

import java.util.List;

import com.zzy.test.entity.Message;

public interface MessageDao {
	List<Message> getMessageDetail(String username);
	//添加信息
	public int insert(Message message);
	int countMessageByName(String name);
}
