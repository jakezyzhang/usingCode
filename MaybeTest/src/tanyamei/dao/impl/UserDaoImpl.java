package tanyamei.dao.impl;

import java.sql.SQLException;

import tanyamei.dao.BaseDao;
import tanyamei.dao.UserDao;
import tanyamei.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao{
	public int insert(User user){
		String username = user.getUsername();
		String password = user.getPassword();
		int power = user.getUserpower();
		String sql = "insert into user values('"
				+username+"','"+password+"','"+power+"')";
		return this.executeUpdate(sql);
	}
	
	public User findUserByUsername(String name){
		String sql = "select * from user where upper(username)=upper('"+name+"')";
		rs = this.executeQuery(sql);
		User user = null;
		if(rs != null){
			try {
				if(rs.next()){
					int id = rs.getInt("user_id");
					String username = rs.getString("username");
					String password = rs.getString("password");
					int power = rs.getInt("userpower");
					
					user = new User(id,username, password, power);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				this.closeAll(conn, pstmt, rs);
			}
		}
		return user;
	}
}
