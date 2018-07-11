package tanyamei.dao;

import java.util.List;

import tanyamei.entity.Vote;

public interface User_VoteDao {
	public int insert(int userid, int voteid);
	public List<Vote> select_notdo(String username);
	public List<Vote> select_do(String username);
}
