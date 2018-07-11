package tanyamei.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tanyamei.dao.BaseDao;
import tanyamei.dao.VoteDao;
import tanyamei.entity.Vote;

public class VoteDaoImpl extends BaseDao implements VoteDao{

	public int insert(Vote vote) {
		String title = vote.getVote_title();
		String[] choices = vote.getChoices();
		String sql = "insert into voteinfo values('"
				+title+"','"+choices[0]+"','"+choices[1]+"','"+choices[2]+"')";
		return this.executeUpdate(sql);
	}

	public List<Vote> allVote() {
		String sql = "select * from voteinfo";
		rs = this.executeQuery(sql);
		ArrayList<Vote> list = new ArrayList<Vote>();
		if(rs != null){
			try{
				while(rs.next()){
					int id = rs.getInt("vote_id");
					String title = rs.getString("title");
					String[] choices = new String[3];
					choices[0] = rs.getString("choice1");
					choices[1] = rs.getString("choice2");
					choices[2] = rs.getString("choice3");
					
					list.add(new Vote(id, title, choices));
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
