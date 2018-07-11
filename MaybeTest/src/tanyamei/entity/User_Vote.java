package tanyamei.entity;

public class User_Vote {
	private int user_id;
	private int vote_id;
	private int isvote;
	public User_Vote(int userid,int voteid,int isvote){
		this.user_id = userid;
		this.vote_id = voteid;
		this.isvote = isvote;
	}
	public int getUser_id() {
		return user_id;
	}
	public int getVote_id() {
		return vote_id;
	}
	public int getIsvote() {
		return isvote;
	}
}
