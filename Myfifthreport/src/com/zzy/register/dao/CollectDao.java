package com.zzy.register.dao;

import java.util.List;
import java.util.Vector;

import com.zzy.register.entity.Collect;


public interface CollectDao {
	public int countCollectByWebName(String username);
	public Collect findUserByWebName(String username);
	public Vector<Collect> findCollectsByWebName(String username);
	public List<Collect> getAll(String username);
	//添加网站
	public int insert(Collect collect);
}
