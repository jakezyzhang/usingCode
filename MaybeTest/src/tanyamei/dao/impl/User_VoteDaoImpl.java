package tanyamei.dao.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tanyamei.dao.BaseDao;
import tanyamei.dao.User_VoteDao;
import tanyamei.entity.Vote;

public class User_VoteDaoImpl extends BaseDao implements User_VoteDao{

	public int insert(int userid, int voteid) {
		String sql = "insert into user_vote values('"
				+userid+"','"+voteid+"','"+1+"')";
		return this.executeUpdate(sql);
	}
	public List<Vote> select_notdo(String username) {
		String sql = "select * from user where username='"+username+"'";
		rs = this.executeQuery(sql);
		int user_id=0;
		if(rs != null){
			try {
				if(rs.next()){
					user_id = rs.getInt("user_id");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		String newsql = "select * from voteinfo where vote_id not exist (select vote_id form user_vote where user_id="+user_id+")";
		rs = this.executeQuery(newsql);
		ArrayList<Vote> list = new ArrayList<Vote>();
		if(rs != null){
			try{
				while(rs.next()){
					int voteid = rs.getInt("vote_id");
					String title = rs.getString("title");
					String[] choices = new String[3];
					choices[0] = rs.getString("choice1");
					choices[1] = rs.getString("choice2");
					choices[2] = rs.getString("choice3");
					
					list.add(new Vote(voteid, title, choices));
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				this.closeAll(conn, pstmt, rs);
			}
		}
		return list;
	}

	public List<Vote> select_do(String username) {
		String sql = "select * from user where username='"+username+"'";
		rs = this.executeQuery(sql);
		int user_id=0;
		if(rs != null){
			try {
				if(rs.next()){
					user_id = rs.getInt("user_id");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		String newsql = "select * from voteinfo where vote_id in (select vote_id form user_vote where user_id="+user_id+")";
		rs = this.executeQuery(newsql);
		ArrayList<Vote> list = new ArrayList<Vote>();
		if(rs != null){
			try{
				while(rs.next()){
					int voteid = rs.getInt("vote_id");
					String title = rs.getString("title");
					String[] choices = new String[3];
					choices[0] = rs.getString("choice1");
					choices[1] = rs.getString("choice2");
					choices[2] = rs.getString("choice3");
					
					list.add(new Vote(voteid, title, choices));
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				this.closeAll(conn, pstmt, rs);
			}
		}
		return list;
	}
}
