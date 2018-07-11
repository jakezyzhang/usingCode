package tanyamei.dao;

import java.util.List;

import tanyamei.entity.Vote;

public interface VoteDao {
	public int insert(Vote vote);
	public List<Vote> allVote();
}